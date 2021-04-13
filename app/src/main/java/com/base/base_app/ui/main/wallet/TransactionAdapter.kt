package com.base.base_app.ui.main.wallet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.bime.data.model.TransactionModel
import com.example.bilerplatemvvm.R
import kotlinx.android.synthetic.main.item_transaction.view.*

class TransactionAdapter (val list: ArrayList<TransactionModel>) :
    RecyclerView.Adapter<TransactionAdapter.DataViewHolder>() {
    lateinit var context: Context

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(transactionModel:TransactionModel) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindData(list[position])
        if(list[position].state==1){
            holder.itemView.img_increase_transaction.visibility=View.VISIBLE
            holder.itemView.img_decrease_transaction.visibility=View.INVISIBLE
        }else{
            holder.itemView.img_increase_transaction.visibility=View.GONE
            holder.itemView.img_decrease_transaction.visibility=View.VISIBLE

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setMyContext(myConetxt: Context){
        context=myConetxt
    }
    fun addItems(myList:MutableList<TransactionModel>){
        list.clear()
        list.addAll(myList)
    }
}