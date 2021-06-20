package com.kasra.atency.ui.base

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bilerplatemvvm.R
import com.muddzdev.styleabletoastlibrary.StyleableToast

open class BaseFragment constructor(contentLayoutId:Int) : Fragment(contentLayoutId){

    open fun showErrorMessage(message:String){
        activity?.let {
            StyleableToast.Builder(it)
                .text(message)
                .textColor(ContextCompat.getColor(it, R.color.colorwhite))
                .backgroundColor(ContextCompat.getColor(it, R.color.colorRedToast))
                .iconStart(R.drawable.ic_cancle_circle)
                .font(R.font.dana_fa_medium)
                .show()
        }
    }
    open fun showMessage(message:String){
        activity?.let {
            StyleableToast.Builder(it)
                .text(message)
                .textColor(ContextCompat.getColor(it, R.color.colorwhite))
                .backgroundColor(ContextCompat.getColor(it, R.color.colorGreenToast))
                .iconStart(R.drawable.ic_check_circle)
                .font(R.font.dana_fa_medium)
                .show()
        }
    }
    open fun initGridRecycler(recyclerView: RecyclerView): RecyclerView {
        recyclerView.layoutManager = GridLayoutManager(context,3)
        return recyclerView
    }
    open fun initVerticalRecycler(recyclerView: RecyclerView): RecyclerView {
        recyclerView.layoutManager = LinearLayoutManager(context)
        return recyclerView
    }

}