package com.base.bime.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bilerplatemvvm.R
import kotlinx.android.synthetic.main.item_layout.view.*


class MainAdapter(
    private val userInfos: ArrayList<String>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
//            itemView.textViewUserName.text = userInfo.name
//            itemView.textViewUserEmail.text = userInfo.email

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = userInfos.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {}
//        holder.bind(userInfos[position])

    fun addData() {
//        userInfos.addAll(list)
    }
}