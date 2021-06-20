package com.kasra.atency.utility

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.bottomsheet.BottomSheetDialog


fun changeDrawableColor(context: Context, drawable: Drawable, color: Int) {
    drawable.setColorFilter(
        ContextCompat.getColor(context, color),
        PorterDuff.Mode.MULTIPLY
    )
}

fun CustomBottomSheetDialog(
    context: Context?,
    view: View
): BottomSheetDialog? {
    val dialog = BottomSheetDialog(context!!)
    dialog.setContentView(view)
    dialog.show()
    dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
    return dialog
}

fun showPopUp(context: Context): AlertDialog {
    val dialog = AlertDialog.Builder(context).create()
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setCanceledOnTouchOutside(true)
    return dialog
}
fun changeStrokeColor(view: View, color: Int) {
    val drawable = view.background as GradientDrawable
    drawable.setStroke(3, color)
}

fun changeSolidColor(view: View, color: Int) {
    val drawable = view.background as GradientDrawable
    drawable.setColor(color)
}



