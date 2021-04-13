package com.base.base_app.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.base.base_app.data.model.BaseModel
import com.base.base_app.ui.base.BaseFragment
import com.base.base_app.utility.CustomResponse
import com.base.bime.utility.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen
import com.example.bilerplatemvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.home_fragment) {
    val homeViewModel: HomeViewModel by viewModels()
    lateinit var list: List<BaseModel>
    lateinit var skeletonScreen: ViewSkeletonScreen

    @Inject
    lateinit var insuranceListAdapter: InsurancesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromRepository()
        skeletonScreen=Skeleton.initSkeleton(root_home_page,R.layout.home_skelton)
        homeViewModel.getVehicleInsurancePolicy()
    }

    private fun openThirdInsurancePolicy(id:String) {
//        val intent = Intent(activity, ThirdPartyInsuranceAcivity::class.java)
//        intent.putExtra("insuranceId", id)
//        activity?.startActivity(intent)
    }

    private fun getDataFromRepository() {
        homeViewModel._VehicleInsurancePolicy.observe(
            viewLifecycleOwner,
            {
                skeletonScreen.hide()
                when (it.status) {
                    CustomResponse.Status.SUCCESS -> {
                        list = it.data!!
                        initGridLayout(list)
                    }
                    CustomResponse.Status.ERROR -> {
                        showErrorMessage(it.message.toString())
                    }
                    CustomResponse.Status.Fail -> {
                        showErrorMessage(it.message.toString())
                    }
                }
            })
        insuranceListAdapter._baseModel.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it._id) {
                "5fc395dba2b58c15b93c81c9" -> {
                    openThirdInsurancePolicy(it._id)
                }
                "5fc395dba2b58c15b93c81ca" -> {
                }
            }
        })
    }

    private fun initGridLayout(list: List<BaseModel>) {
        var recyclerView = view?.rv_insurances
        recyclerView = recyclerView?.let { initGridRecycler(it) }
        recyclerView?.adapter=insuranceListAdapter
        context.let {insuranceListAdapter.setMyContext(it!!)}
        insuranceListAdapter.addData(list)

    }

}