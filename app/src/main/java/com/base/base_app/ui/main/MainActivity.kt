package com.base.base_app.ui.main

import android.os.Build
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.base_app.ui.base.BaseActivity
import com.base.base_app.ui.main.insurance_history.InsuranceHistory
import com.base.base_app.ui.main.wallet.WalletFragment
import com.base.bime.ui.main.MainAdapter
import com.base.base_app.ui.main.home.HomeFragment
import com.base.base_app.ui.main.profile.ProfileFragment
import com.base.base_app.utility.MyContextWrapper
import com.example.bilerplatemvvm.R
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyContextWrapper.wrap(this, Locale("fa"))
        setUpUi()
        setUpObservable()
        initView()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            changeStatusColor()
        }

    }

    private fun setUpUi() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun initView() {
        nav_view.setItemHorizontalTranslationEnabled(false)
        nav_view.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_SELECTED)
        nav_view.setOnNavigationItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.nav_home -> {
                    val homeFragment: HomeFragment? =
                        supportFragmentManager.findFragmentByTag("homeFragment") as HomeFragment?
                    if (homeFragment != null) {
                        hideOtherFragment("homeFragment")
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(
                                R.id.main_frame_layout,
                                HomeFragment(),
                                "homeFragment"
                            )
                            .addToBackStack(null)
                            .commit()
                    }
                }
                R.id.nav_insurance_history -> {
                    val insuranceHistory: InsuranceHistory? =
                        supportFragmentManager.findFragmentByTag("insuranceHistory") as InsuranceHistory?
                    if (insuranceHistory != null) {
                        hideOtherFragment("insuranceHistory")
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(
                                R.id.main_frame_layout,
                                InsuranceHistory(),
                                "insuranceHistory"
                            )
                            .addToBackStack(null)
                            .commit()

                    }
                }
                R.id.nav_wallet -> {
                    val walletFragment: WalletFragment? =
                        supportFragmentManager.findFragmentByTag("walletFragment") as WalletFragment?
                    if (walletFragment != null) {
                        hideOtherFragment("walletFragment")
                    } else {

                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frame_layout, WalletFragment(), "walletFragment")
                            .addToBackStack(null)
                            .commit()                    }
                }
                R.id.nav_profile -> {
                    val profileFragment: ProfileFragment? =
                        supportFragmentManager.findFragmentByTag("profileFragment") as ProfileFragment?
                    if (profileFragment != null) {
                        hideOtherFragment("profileFragment")
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frame_layout, ProfileFragment(), "profileFragment")
                            .addToBackStack(null)
                            .commit()
                    }
                }

                else -> throw IllegalStateException("Unexpected value: " + item.getItemId())
            }
            true
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.main_frame_layout, HomeFragment(), "homeFragment")
            .addToBackStack(null)
            .commit()
        nav_view.setSelectedItemId(R.id.nav_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    private fun setUpObservable() {
//        mainViewModel.userInfo.observe(this, Observer {
//            when(it.status){
//                CustomResponse.Status.SUCCESS->{
//                    it.data?.let { users -> renderList(users) }
//                }
//
//            }
//
//        })
    }

    //    private fun renderList(userInfos: List<UserInfo>) {
//        adapter.addData(userInfos)
//        adapter.notifyDataSetChanged()
//    }
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


}