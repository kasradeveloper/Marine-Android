package com.base.base_app.ui.main

import android.content.pm.PackageInfo
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.base.base_app.ui.base.BaseActivity
import com.base.base_app.ui.main.home.HomeFragment
import com.base.base_app.utility.MyContextWrapper
import com.base.bime.ui.main.MainAdapter
import com.example.bilerplatemvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import java.io.File
import java.io.IOException
import java.util.*

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyContextWrapper.wrap(this, Locale("fa"))
        initView()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            changeStatusColor()
        }

    }
    fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer_layout.closeDrawer(GravityCompat.START)
        fl = findViewById(R.id.rootLayout)
        when (item.itemId) {
            R.id.nav_logout -> mainViewModel.logout()
//            R.id.nav_requests -> {
//                //                removeAllFragment();
//                hideOtherFragment("Requests")
//                val fragment: RequestsFragment? =
//                    supportFragmentManager.findFragmentByTag("Requests") as RequestsFragment?
//                if (fragment == null) fragmentManager.beginTransaction()
//                    .add(R.id.rootLayout, RequestsFragment(), "Requests").commitAllowingStateLoss()
//            }
//            R.id.nav_portfolio -> {
//                //                removeAllFragment();
//                hideOtherFragment("portfolio")
//                val requestsFragment: PortfolioFragment? =
//                    supportFragmentManager.findFragmentByTag("portfolio") as PortfolioFragment?
//                if (requestsFragment == null) fragmentManager.beginTransaction()
//                    .add(R.id.rootLayout, PortfolioFragment(), "portfolio")
//                    .commitAllowingStateLoss()
//            }
//            R.id.nav_outdoor_duty -> {
//                //                removeAllFragment();
//                hideOtherFragment("OutDoorDuty")
//                val workplacesFragment: WorkplacesFragment? =
//                    supportFragmentManager.findFragmentByTag("OutDoorDuty") as WorkplacesFragment?
//                if (workplacesFragment == null) fragmentManager.beginTransaction()
//                    .add(R.id.rootLayout, WorkplacesFragment(), "OutDoorDuty")
//                    .commitAllowingStateLoss()
//            }
//            R.id.nav_messages -> {
//                //                removeAllFragment();
//                hideOtherFragment("Messages")
//                val messageInboxFragment: MessageInboxFragment? =
//                    supportFragmentManager.findFragmentByTag("Messages") as MessageInboxFragment?
//                if (messageInboxFragment == null) fragmentManager.beginTransaction()
//                    .add(R.id.rootLayout, MessageInboxFragment(), "Messages")
//                    .commitAllowingStateLoss()
//            }
//            R.id.nav_performance -> {
//                //                removeAllFragment();
//                hideOtherFragment("Performance")
//                val performance: PerformanceFragment? =
//                    supportFragmentManager.findFragmentByTag("Performance") as PerformanceFragment?
//                if (performance == null) fragmentManager.beginTransaction()
//                    .add(R.id.rootLayout, PerformanceFragment(), "Performance")
//                    .commitAllowingStateLoss()
//            }
            R.id.nav_subperson -> {
                //                removeAllFragment();
                hideOtherFragment("SubPerson")
                val subPerson: SubPersonFragment? =
                    supportFragmentManager.findFragmentByTag("SubPerson") as SubPersonFragment?
                if (subPerson == null) fragmentManager.beginTransaction()
                    .add(R.id.rootLayout, SubPersonFragment(), "SubPerson")
                    .commitAllowingStateLoss()
                return true
            }
            R.id.nav_home -> {
                //                removeAllFragment();
                hideOtherFragment("Home")
                val home = supportFragmentManager.findFragmentByTag("Home") as HomeFragment?
                if (home == null) fragmentManager.beginTransaction()
                    .add(R.id.rootLayout, HomeFragment(), "Home").commitAllowingStateLoss()
            }
//            R.id.nav_ticket -> {
//                //                removeAllFragment();
//                hideOtherFragment("Ticket")
//                val ticketFragment: TicketFragment? =
//                    supportFragmentManager.findFragmentByTag("Ticket") as TicketFragment?
//                if (ticketFragment == null) fragmentManager.beginTransaction()
//                    .add(R.id.rootLayout, TicketFragment(), "Ticket").commitAllowingStateLoss()
//            }
            R.id.nav_setting -> showErrorMessage(
                getResources().getString(R.string.next_version)
            )
        }
        return true
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }

    private fun hideOtherFragment(tag: String?) {
        for (i in supportFragmentManager.fragments.indices) {
            if (supportFragmentManager.fragments[i].tag.equals(tag)) {
                supportFragmentManager.beginTransaction()
                    .show(supportFragmentManager.fragments[i])
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .hide(supportFragmentManager.fragments[i])
                    .commit()
            }
        }
    }
    private fun initView() {
        //init Toolbar in view
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        // init Navigation Menu in view
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setCheckedItem(R.id.nav_home)
        nav_view.setNavigationItemSelectedListener(this)
        setItemsInNavDrawer()
    }
    private fun setItemsInNavDrawer() {
        try {
            nav_view.inflateMenu(R.menu.activity_main_drawer)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                for (i in 0 until nav_view.getMenu().size()) {
                    when (i) {
                        0 -> nav_view.getMenu().getItem(i).setIcon(R.drawable.ic_map_marker)
                        1 -> nav_view.getMenu().getItem(i).setIcon(R.drawable.icon_calendar)
                        2 -> nav_view.getMenu().getItem(i).setIcon(R.drawable.icon_calendar)
                        3 -> nav_view.getMenu().getItem(i)
                            .setIcon(R.drawable.ic_folder_download)
                        4 -> nav_view.getMenu().getItem(i)
                            .setIcon(R.drawable.ic_file_edit_alt)
                        5 -> nav_view.getMenu().getItem(i).setIcon(R.drawable.ic_envelope_alt)
                        6 -> nav_view.getMenu().getItem(i)
                            .setIcon(R.drawable.icon_outdoor_duty_location)
                        7 -> nav_view.getMenu().getItem(i)
                            .setIcon(R.drawable.ic_envelope_upload)
                        8 -> nav_view.getMenu().getItem(i).setIcon(R.drawable.menu_setting)
                        9 -> nav_view.getMenu().getItem(i).setIcon(R.drawable.ic_sign_out_alt)
                    }
                }
            }
            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.nav_header_main, null)
            nav_view.addHeaderView(view)
            val parentView: View = nav_view.getHeaderView(0)
            profilePic = parentView.findViewById(R.id.profile_picture)
            cameraImage = parentView.findViewById(R.id.camera_img)
            progressImage = parentView.findViewById<ProgressBar>(R.id.imge_progress)
            parentView.camera_img.background=ContextCompat.getDrawable(this,R.drawable.plus_icon)
            mainPresenter.getUserInfoApiCall(profilePic)
            navDisplayName = parentView.findViewById(R.id.nav_display_name)
            navPersonnelCode = parentView.findViewById(R.id.nav_personnel_code)
            navVersionTag = findViewById(R.id.nav_version_tag)
            navVDeviceID = findViewById(R.id.nav_device_id)
            profileLoading = parentView.findViewById<FrameLayout>(R.id.image_loading)
            if (mainPresenter.getUserInfo() != null) {
                navDisplayName.setText(mainPresenter.getUserInfo().getGivenName())
                navPersonnelCode.setText(
                    mainPresenter.getUserInfo().getAddress().getPersonnelCode()
                )
            }
            val pInfo: PackageInfo
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0)
            val version = pInfo.versionName
            val type =
                Typeface.createFromAsset(context.getAssets(), "fonts/Roboto/Roboto-Light.ttf")
            navVersionTag.setTypeface(type)
            navVersionTag.setText(String.format("Atency co, v%s", version))
            navVDeviceID.setTypeface(type)
            val deviceID: String = getUniquePsuedoID()
            val showdeviceID = deviceID.substring(deviceID.length - 10, deviceID.length - 1)
            navVDeviceID.setText(
                "DeviceID : " + String.format(
                    "%1\$s-%2\$s-%3\$s",
                    showdeviceID.substring(0, 3),
                    showdeviceID.substring(3, 6),
                    showdeviceID.substring(6, 9)
                )
            )
        } catch (e: Exception) {
            Sentry.captureException(e)
        }
        profilePic.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("show_file", false)
            bundle.putInt("come_from", 5)
            documentBottomSheet.setArguments(bundle)
            documentBottomSheet.show(
                supportFragmentManager,
                "add_document_dialog_fragment"
            )
            documentBottomSheet.setCallBack(object : Callback() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Throws(IOException::class)
                fun sendData(Data: File?) {
                    progressImage.setVisibility(View.VISIBLE)
                    mainPresenter.uploadImgApiCall(Data, profilePic)
                }
            })
        })
    }

}