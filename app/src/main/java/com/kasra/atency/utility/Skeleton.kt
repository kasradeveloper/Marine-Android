package com.kasra.bime.utility

import android.view.View
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen

class Skeleton {
    companion object{
        fun initSkeleton(rootView: View,skeletonLayout: Int): ViewSkeletonScreen=Skeleton.bind(rootView).load(skeletonLayout).duration(2500).shimmer(true).show()
        fun showSkeleton(skeletonScreen: ViewSkeletonScreen)=skeletonScreen.show()
        fun hideSkeleton(skeletonScreen: ViewSkeletonScreen)=skeletonScreen.hide()
    }
}