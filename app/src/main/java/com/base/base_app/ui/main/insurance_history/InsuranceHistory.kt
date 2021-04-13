package com.base.base_app.ui.main.insurance_history

import android.os.Bundle
import android.view.View
import com.base.base_app.ui.base.BaseFragment
import com.base.bime.data.model.InsuranceModel
import com.example.bilerplatemvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.insurance_history_fragment.view.*
import javax.inject.Inject

@AndroidEntryPoint
class InsuranceHistory : BaseFragment(R.layout.insurance_history_fragment) {
    @Inject
    lateinit var insuranceListAdapter: InsuranceListAdapter
    val  insuranceList: MutableList<InsuranceModel> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerView = initVerticalRecycler(view.insurance_list)
        recyclerView.adapter = insuranceListAdapter
        context?.let { insuranceListAdapter.setMyContext(it) }
        val insuranceModel = InsuranceModel(0)
        insuranceList.add(insuranceModel)
        val insuranceModel2 = InsuranceModel(1)
        insuranceList.add(insuranceModel2)
        insuranceListAdapter.addItems(insuranceList)
    }

}