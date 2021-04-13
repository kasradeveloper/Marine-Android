package com.base.base_app.ui.main.wallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.base.base_app.ui.base.BaseFragment
import com.base.bime.data.model.TransactionModel

import com.example.bilerplatemvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.wallet_fragment.view.*
import javax.inject.Inject
@AndroidEntryPoint
class WalletFragment :BaseFragment(R.layout.wallet_fragment) {
    @Inject
    lateinit var transactionAdapter:TransactionAdapter
    val transactionList:MutableList<TransactionModel> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        view.increase_credit_btn.setOnClickListener {
//            val intent=Intent(activity,IncreaseCreditActivity::class.java)
//            activity?.startActivity(intent)
//        }
//        view.checkout_btn.setOnClickListener {
//            val intent=Intent(activity,CheckoutActivity::class.java)
//            activity?.startActivity(intent)
//        }
        val recyclerView=initVerticalRecycler(view.transaction_rv)
        recyclerView.adapter = transactionAdapter
        context?.let { transactionAdapter.setMyContext(it) }
        val transactionModel = TransactionModel(0)
        transactionList.add(transactionModel)
        val transactionModel2 = TransactionModel(1)
        transactionList.add(transactionModel2)
        val transactionModel3 = TransactionModel(0)
        transactionList.add(transactionModel3)
        val transactionModel4 = TransactionModel(1)
        transactionList.add(transactionModel4)
        transactionAdapter.addItems(transactionList)
        super.onViewCreated(view, savedInstanceState)
    }

}