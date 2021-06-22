package com.kasra.atency.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.bilerplatemvvm.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.navigation.NavigationView
import com.google.firebase.messaging.FirebaseMessaging
import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.model.update.CheckUpdateResponseModel
import com.kasra.atency.ui.base.BaseActivity
import com.kasra.atency.ui.modules.duty.DutyFragment
import com.kasra.atency.ui.modules.home.HomeFragment
import com.kasra.atency.ui.modules.message.MessageFragment
import com.kasra.atency.ui.modules.performance.PerformanceFragment
import com.kasra.atency.ui.modules.portfolio.PortfolioFragment
import com.kasra.atency.ui.modules.request.RequestFragment
import com.kasra.atency.ui.modules.subordinate.SubordinateFragment
import com.kasra.atency.ui.modules.ticket.TicketFragment
import com.kasra.atency.utility.*
import com.kasra.atency.utility.enums.ActivityName
import com.kasra.atency.utility.enums.FragmentName
import com.kasra.atency.utility.enums.MyEnums
import dagger.hilt.android.AndroidEntryPoint
import io.sentry.Sentry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*


@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main),
    NavigationView.OnNavigationItemSelectedListener {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeItems()
        createMenu()
        mainViewModel.getUserPermission()
        mainViewModel.getBadgeMessage()
        mainViewModel.getUserInfo()
        if (checkPermissionLocation(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 124)
            }
        }
        mainViewModel.checkUpdate()
        getFireBaseToken()
    }

    override fun observeItems() {
        mainViewModel.permissions.observe(this, {
            if (it.status == CustomResponse.Status.SUCCESS) {
                checkPermission(it.data!!)
            }
        })
        mainViewModel.badgeNumber.observe(this, {
            createBadge(it)
        })
        mainViewModel.userInfo.observe(this, {
            initNavHeader(it)
            if (it != null) {
                val lang: String =
                    it.address?.locale.toString()
                SetLanguage.updateLanguage(this, lang)
            } else {
                SetLanguage.updateLanguage(this, "fa")
            }
//            val glideUrl = GlideUrl(ApiBaseCreator.getUrl().toString() + url, LazyHeaders.Builder()
//                .addHeader(
//                    "Authorization"
//                ) { "Bearer " + AppPreferences.getInstance(adapterContext).getAccessToken() }
//                .build())
//
//            Glide.with(this)
//                .load(glideUrl)
//                .dontTransform()
//                .dontAnimate()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(myHolder.profileImage)
        })
        mainViewModel.logout.observe(this, {
            openActivity(ActivityName.LOGIN)
        })
        mainViewModel.checkUpdate.observe(this, {
            when (it.status) {
                CustomResponse.Status.SUCCESS -> {
                    handleCheckForUpdate(it.data!!)
                }
                CustomResponse.Status.FAIL, CustomResponse.Status.ERROR -> {
                    showErrorMessage(it.message.toString())
                }

            }
        })
        mainViewModel.mutableupdateCell.observe(this, {
            when (it.status) {
                CustomResponse.Status.FAIL, CustomResponse.Status.ERROR -> {
                    showErrorMessage(it.message.toString())
                }
            }
        })
    }

    private fun createMenu() {
        nav_view.inflateMenu(R.menu.activity_main_drawer)
        setIconMenu()
        nav_view.setCheckedItem(R.id.nav_home)
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun setIconMenu() {
        for (i in 0 until nav_view.menu.size()) {
            when (i) {
                0 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_map_marker)
                1 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_calendar)
                2 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_calendar)
                3 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_folder_download)
                4 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_file_edit_alt)
                5 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_envelope_alt)
                6 -> nav_view.menu.getItem(i).setIcon(R.drawable.icon_outdoor_duty_location)
                7 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_envelope_upload)
                8 -> nav_view.menu.getItem(i).setIcon(R.drawable.menu_setting)
                9 -> nav_view.menu.getItem(i).setIcon(R.drawable.ic_sign_out_alt)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initNavHeader(userInfo: UserInfo) {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.nav_header_main, null)
        nav_view.addHeaderView(view)
        val parentView: View = nav_view.getHeaderView(0)
        parentView.nav_display_name.text = userInfo.givenName
        parentView.nav_personnel_code.text = userInfo.address?.personnelCode
        val pInfo = packageManager.getPackageInfo(this.packageName, 0)
        val version = pInfo.versionName
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            nav_view.nav_version_tag.setTypeface(resources.getFont(R.font.font_light))
            nav_view.nav_device_id.setTypeface(resources.getFont(R.font.font_light))

        }
        nav_view.nav_version_tag.text = String.format("Atency co, v%s", version)
        val deviceID: String = getUniquePsuedoID()
        val showdeviceID = deviceID.substring(deviceID.length - 10, deviceID.length - 1)
        nav_view.nav_device_id.text = "DeviceID : " + java.lang.String.format(
            "%1\$s-%2\$s-%3\$s",
            showdeviceID
        )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer_layout.closeDrawer(GravityCompat.START)
        when (item.itemId) {
            R.id.nav_logout -> mainViewModel.logoutHandler()
            R.id.nav_requests -> {
                val fragment: RequestFragment? =
                    supportFragmentManager.findFragmentByTag("request_fragment") as RequestFragment?
                if (fragment == null)
                    showNextFragment(FragmentName.REQUEST, layout = R.id.rootLayout)
                else
                    hideOtherFragment("request_fragment")
            }
            R.id.nav_portfolio -> {
                val requestsFragment: PortfolioFragment? =
                    supportFragmentManager.findFragmentByTag("portfolio_fragment") as PortfolioFragment?
                if (requestsFragment == null)
                    showNextFragment(FragmentName.PORTFOLIO, layout = R.id.rootLayout)
                else
                    hideOtherFragment("portfolio_fragment")
            }
            R.id.nav_outdoor_duty -> {
                val dutyFragment: DutyFragment? =
                    supportFragmentManager.findFragmentByTag("duty_fragment") as DutyFragment?
                if (dutyFragment == null)
                    showNextFragment(FragmentName.DUTY, layout = R.id.rootLayout)
                else
                    hideOtherFragment("duty_fragment")
            }
            R.id.nav_messages -> {
                val messageFragment: MessageFragment? =
                    supportFragmentManager.findFragmentByTag("message_fragment") as MessageFragment?
                if (messageFragment == null)
                    showNextFragment(FragmentName.MESSAGER, layout = R.id.rootLayout)
                else
                    hideOtherFragment("message_fragment")
            }
            R.id.nav_performance -> {
                val performance: PerformanceFragment? =
                    supportFragmentManager.findFragmentByTag("performance_fragment") as PerformanceFragment?
                if (performance == null)
                    showNextFragment(FragmentName.PERFORMANCE, layout = R.id.rootLayout)
                else
                    hideOtherFragment("performance_fragment")
            }
            R.id.nav_subperson -> {
                val subPerson: SubordinateFragment? =
                    supportFragmentManager.findFragmentByTag("subordinate_fragment") as SubordinateFragment?
                if (subPerson == null)
                    showNextFragment(FragmentName.SUBORDINATE, layout = R.id.rootLayout)
                else
                    hideOtherFragment("subordinate_fragment")
            }
            R.id.nav_home -> {
                val home: HomeFragment? =
                    supportFragmentManager.findFragmentByTag("home_fragment") as HomeFragment?
                if (home == null)
                    showNextFragment(FragmentName.HOME, layout = R.id.rootLayout)
                else
                    hideOtherFragment("home_fragment")
            }
            R.id.nav_ticket -> {
                val ticketFragment: TicketFragment? =
                    supportFragmentManager.findFragmentByTag("ticket_fragment") as TicketFragment?
                if (ticketFragment == null)
                    showNextFragment(FragmentName.TICKET, layout = R.id.rootLayout)
                else
                    hideOtherFragment("ticket_fragment")

            }
        }
        return true
    }

    private fun hideOtherFragment(tag: String) {
        for (i in supportFragmentManager.fragments.indices) {
            if (supportFragmentManager.fragments[i].tag == tag) {
                supportFragmentManager.beginTransaction()
                    .show(supportFragmentManager.fragments[i])
                    .commitAllowingStateLoss()
            } else {
                supportFragmentManager.beginTransaction()
                    .hide(supportFragmentManager.fragments[i])
                    .commitAllowingStateLoss()
            }
        }
    }

    private fun handleSubordinateItems(hasSubordinatePermission: Boolean) {
        if (hasSubordinatePermission) {
            onNavigationItemSelected(nav_view.menu.getItem(1))
            nav_view.setCheckedItem(R.id.nav_subperson)
            val menu: Menu = nav_view.menu
            menu.findItem(R.id.nav_performance).isVisible = false
            menu.findItem(R.id.nav_subperson).isVisible = true
        } else {
            onNavigationItemSelected(nav_view.menu.getItem(0))
            nav_view.setCheckedItem(R.id.nav_home)
            val menu: Menu = nav_view.menu
            menu.findItem(R.id.nav_performance).isVisible = true
            menu.findItem(R.id.nav_subperson).isVisible = false
        }
    }

    private fun checkPermission(permissions: List<PermissionResponseModel>) {
        handleSubordinateItems(permissions.any { it.id == Integer.valueOf(MyEnums.Permissions.SUBORDINATES_REQUEST.toString()) })
        nav_view.menu.findItem(R.id.nav_outdoor_duty).isVisible = permissions.any {
            it.id == Integer.valueOf(
                MyEnums.Permissions.OUTDOOR_MODULE.toString()
            )
        }
        nav_view.menu.findItem(R.id.nav_messages).isVisible = permissions.any {
            it.id == Integer.valueOf(
                MyEnums.Permissions.MESSAGE.toString()
            )
        }
        nav_view.menu.findItem(R.id.nav_ticket).isVisible = permissions.any {
            it.id == Integer.valueOf(
                MyEnums.Permissions.TICKET_MODULE.toString()
            )
        }
        nav_view.menu.findItem(R.id.nav_portfolio).isVisible = permissions.any {
            it.id == Integer.valueOf(
                MyEnums.Permissions.SHOW_portfolio.toString()
            )
        }
    }

    private fun createBadge(number: Int) {
        try {
            val navMenu: Menu = nav_view.menu
            val menuItem = navMenu.findItem(R.id.nav_messages)
            val badgeLayout = findViewById<FrameLayout>(R.id.badge_layout)
            val rootView = menuItem.actionView as FrameLayout
            if (Integer.valueOf(number) > 0) {
                badgeLayout!!.visibility = View.VISIBLE
                if (number > 0) {
                    val txtView = rootView.findViewById<TextView>(R.id.number_badge_txt)
                    txtView.setText(number)
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        txtView.setTypeface(resources.getFont(R.font.font_light))
                    }
                    txtView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                    val drawable =
                        rootView.findViewById<View>(R.id.circle_badge_icon).background as GradientDrawable
                    drawable.setColor(ContextCompat.getColor(this, R.color.colorWhite))
                    drawable.setStroke(3, ContextCompat.getColor(this, R.color.colorPrimary))
                } else {
                    rootView.visibility = View.GONE
                }
            } else {
                if (badgeLayout != null) badgeLayout.visibility = View.GONE
            }
        } catch (e: Exception) {
            Sentry.captureException(e)
        }
    }

    fun handleCheckForUpdate(checkUpdateResponseModel: CheckUpdateResponseModel) {
        if (checkUpdateResponseModel.updateType?.value.equals(MyEnums.UpdateType.FORCE.toString())) {
            val inflater = LayoutInflater.from(this)
            val view = inflater.inflate(R.layout.check_update_dialog, null)
            val checkUpdateDialog = customDialog(this, view)
            checkUpdateDialog.setCancelable(false)
            checkUpdateDialog.setCanceledOnTouchOutside(false)
            checkUpdateDialog.getWindow()?.setBackgroundDrawable(
                ColorDrawable(
                    Color.TRANSPARENT
                )
            )
            val abortBtn = view.findViewById<Button>(R.id.force_update_abort_button)
            abortBtn.setOnClickListener { v: View? ->
                finish()
                System.exit(0)
            }
            val updateBtn = view.findViewById<Button>(R.id.update_button)
            updateBtn.setOnClickListener { v: View? ->
                val uriUrl =
                    Uri.parse(checkUpdateResponseModel.storeURL)
                val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                startActivity(launchBrowser)
            }
        }
    }

    fun getFireBaseToken() {
        try {
            FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(OnCompleteListener<String?> { task -> // Get new FCM registration token
                    try {
                        val token = task.result
                        mainViewModel.updateCellInfo(token)
                    } catch (e: java.lang.Exception) {
                        Sentry.captureException(e)
                    }
                })
        } catch (e: java.lang.Exception) {
            Sentry.captureException(e)
        }
    }

}