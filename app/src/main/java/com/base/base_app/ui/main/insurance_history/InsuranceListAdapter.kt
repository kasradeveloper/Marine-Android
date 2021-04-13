package com.base.base_app.ui.main.insurance_history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.base.bime.data.model.InsuranceModel
import com.example.bilerplatemvvm.R
import kotlinx.android.synthetic.main.insurance_item.view.*

class InsuranceListAdapter(val list: ArrayList<InsuranceModel>) :
    RecyclerView.Adapter<InsuranceListAdapter.DataViewHolder>() {
    lateinit var context: Context

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(insuranceModel: InsuranceModel) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.insurance_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindData(list[position])
        if(list[position].state==1){
            holder.itemView.button_state.background=ContextCompat.getDrawable(context,R.drawable.accept_issurance_bg)
            holder.itemView.button_state.setTextColor(ContextCompat.getColor(context,R.color.colorGreenAccept))
            holder.itemView.button_state.text=context.resources.getString(R.string.issuance)
        }else{
            holder.itemView.button_state.background=ContextCompat.getDrawable(context,R.drawable.awaiting_issuance_bg)
            holder.itemView.button_state.setTextColor(ContextCompat.getColor(context,R.color.colorYellowAwaitTxt))
            holder.itemView.button_state.text=context.resources.getString(R.string.awaiting)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setMyContext(myConetxt: Context){
        context=myConetxt
    }
    fun addItems(myList:List<InsuranceModel>){
        list.clear()
        list.addAll(myList)
    }
}