package com.base.base_app.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.base.base_app.data.model.BaseModel

import com.example.bilerplatemvvm.R
import kotlinx.android.synthetic.main.insurances_item.view.*

class InsurancesAdapter(val list: ArrayList<BaseModel>) :
    RecyclerView.Adapter<InsurancesAdapter.DataViewHolder>() {
    private val mutableBaseModel = MutableLiveData<BaseModel>()
    val _baseModel: LiveData<BaseModel>
        get() = mutableBaseModel
    lateinit var context: Context
    lateinit var myToken: String

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.insurances_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            mutableBaseModel.postValue(list[position])
        }
        holder.itemView.item_txt.text=list[position].name

        when (list[position]._id) {
            "5fc395dba2b58c15b93c81c9" -> {
                holder.itemView.item_img.setImageResource(R.drawable.ic_car)
            }
            "5fc395dba2b58c15b93c81ca" -> {
                holder.itemView.item_img.setImageResource(R.drawable.ic_motor)
            }
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addData(myList: List<BaseModel>) {
        list.addAll(myList)
        notifyDataSetChanged()
    }

    fun clearData() {
        list.clear()
    }

    fun setToken(token: String) {
        myToken = token
    }

    fun setMyContext(myConetxt: Context) {
        context = myConetxt
    }

}