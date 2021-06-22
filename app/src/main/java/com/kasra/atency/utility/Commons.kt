package com.kasra.atency.utility

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.sentry.Sentry
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


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
fun getUniquePsuedoID(): String {
    val m_szDevIDShort =
        "35" + Build.BOARD.length % 10 + Build.BRAND.length % 10 + Build.CPU_ABI.length % 10 + Build.DEVICE.length % 10 + Build.MANUFACTURER.length % 10 + Build.MODEL.length % 10 + Build.PRODUCT.length % 10

    // Thanks to @Roman SL!
    // https://stackoverflow.com/a/4789483/950427
    // Only devices with API >= 9 have android.os.Build.SERIAL
    // http://developer.android.com/reference/android/os/Build.html#SERIAL
    // If a user upgrades software or roots their device, there will be a duplicate entry
    var serial: String? = null
    try {
        serial = Build::class.java.getField("SERIAL")[null].toString()

        // Go ahead and return the serial for api => 9
        return md5(
            UUID(
                m_szDevIDShort.hashCode()
                    .toLong(), serial.hashCode().toLong()
            ).toString()
        )
    } catch (exception: Exception) {
        Sentry.captureException(exception)
        // String needs to be initialized
        serial = "serial" // some value
    }

    // Thanks @Joe!
    // https://stackoverflow.com/a/2853253/950427
    // Finally, combine the values we have found by using the UUID class to create a unique identifier
    return md5(
        UUID(
            m_szDevIDShort.hashCode().toLong(),
            serial.hashCode().toLong()
        ).toString()
    )
}
fun md5(s: String): String {
    val MD5 = "MD5"
    try {
        // Create MD5 Hash
        val digest = MessageDigest
            .getInstance(MD5)
        digest.update(s.toByteArray())
        val messageDigest = digest.digest()

        // Create Hex String
        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()
    } catch (e: NoSuchAlgorithmException) {
        Sentry.captureException(e)
    }
    return ""
}
fun checkPermissionLocation(context: Context?): Boolean {
    val permissionState = ActivityCompat.checkSelfPermission(
        context!!,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    return permissionState != PackageManager.PERMISSION_GRANTED
}

fun customDialog(context: Context?, view: View?): AlertDialog {
    val dialog = AlertDialog.Builder(context!!).create()
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setView(view)
    dialog.show()
    dialog.setCanceledOnTouchOutside(false)
    return dialog
}


