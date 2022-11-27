package com.kasra.marine.ui.marine

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Parcelable
import android.provider.MediaStore
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MyChromeClient(private val context: Context, private val activity: AppCompatActivity) :
    WebChromeClient() {
    private var mCapturedImageURI: Uri? = null
    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPath: String? = null
    private var mUploadMessage: ValueCallback<Uri?>? = null
    private val startActivity =
        activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                var results: Array<Uri>? = null
                // Check that the response is a good one


                Log.i("MyChromeClient", "onActivityResult: ${it.resultCode}")
                if (it.resultCode == AppCompatActivity.RESULT_OK) {
                    if (it.data?.dataString == null) {
                        // If there is not data, then we may have taken a photo
                        if (mCapturedImageURI != null) {
                            results = arrayOf(mCapturedImageURI!!)
                        }
                    } else {
                        val dataString = it.data!!.dataString
                        if (dataString != null) {
                            results = arrayOf(Uri.parse(dataString))
                        }
                    }
                }
                mFilePathCallback!!.onReceiveValue(results)
                mFilePathCallback = null
            }
        }

    private var persmissionPendingIntent: Intent? = null
    private val persmissionResultLauncher =
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                startActivity.launch(persmissionPendingIntent)
            } else {
                persmissionPendingIntent?.let { requestPermission(it) }
            }
        }

    // For Android 5.0
    override fun onShowFileChooser(
        view: WebView,
        filePath: ValueCallback<Array<Uri>>,
        fileChooserParams: FileChooserParams
    ): Boolean {
        // Double check that we don't have any existing callbacks
        if (mFilePathCallback != null) {
            mFilePathCallback!!.onReceiveValue(null)
        }
        mFilePathCallback = filePath
        var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "fileName")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image capture by camera")
        mCapturedImageURI = activity.contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
        )
        takePictureIntent?.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI)
//        if (takePictureIntent!!.resolveActivity(context.packageManager) != null) {


//            val fileName = "new-photo-name.jpg"
//            val values = ContentValues()
//            values.put(MediaStore.Images.Media.TITLE, fileName)
//            values.put(MediaStore.Images.Media.DESCRIPTION, "Image capture by camera")
//

            // Create the File where the photo should go
//            var photoFile: File? = null
//            try {
//                photoFile = createImageFile()
//            } catch (ex: IOException) {
//                // Error occurred while creating the File
//                ex.printStackTrace()
//            }
//
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                val photoURI: Uri = FileProvider.getUriForFile(
//                    context,
//                    "com.example.android.fileprovider",
//                    photoFile
//                )
//                mCameraPhotoPath = "file:" + photoFile.absolutePath
//                takePictureIntent.putExtra(
//                    MediaStore.EXTRA_OUTPUT,
//                    photoURI
//                )
//            } else {
//                takePictureIntent = null
//            }
//        }
        val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
        contentSelectionIntent.type = "image/*"
        val intentArray: Array<Intent?> =
            takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
        val chooserIntent = Intent(Intent.ACTION_CHOOSER)
        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)

        if (checkPermission(context))
            startActivity.launch(chooserIntent)
        else
            requestPermission(chooserIntent)

        return true
    }

    // openFileChooser for Android 3.0+
    // openFileChooser for Android < 3.0
    @JvmOverloads
    fun openFileChooser(uploadMsg: ValueCallback<Uri?>?, acceptType: String? = "") {
        mUploadMessage = uploadMsg
        // Create AndroidExampleFolder at sdcard
        // Create AndroidExampleFolder at sdcard
        val imageStorageDir = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            ), "AndroidExampleFolder"
        )
        if (!imageStorageDir.exists()) {
            // Create AndroidExampleFolder at sdcard
            imageStorageDir.mkdirs()
        }
        // Create camera captured image file path and name
        val file = File(
            imageStorageDir.toString() + File.separator + "IMG_"
                    + System.currentTimeMillis().toString() + ".jpg"
        )
        mCapturedImageURI = Uri.fromFile(file)
        // Camera capture image intent
        val captureIntent = Intent(
            MediaStore.ACTION_IMAGE_CAPTURE
        )
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI)
        val i = Intent(Intent.ACTION_GET_CONTENT)
        i.addCategory(Intent.CATEGORY_OPENABLE)
        i.type = "image/*"
        // Create file chooser intent
        val chooserIntent = Intent.createChooser(i, "Image Chooser")
        // Set camera intent to file chooser
        chooserIntent.putExtra(
            Intent.EXTRA_INITIAL_INTENTS, arrayOf<Parcelable>(captureIntent)
        )
        // On select image call onActivityResult method of activity
        startActivity.launch(chooserIntent)
    }

    //openFileChooser for other Android versions
    fun openFileChooser(
        uploadMsg: ValueCallback<Uri?>?,
        acceptType: String?,
        capture: String?
    ) {
        openFileChooser(uploadMsg, acceptType)
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = activity.getExternalFilesDir(
            Environment.DIRECTORY_PICTURES
        )
        val resolver = context.contentResolver
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, imageFileName)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }

        val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)


       return File(uri?.path!!)
    }

    private fun checkPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(chooserIntent: Intent) {
        this.persmissionPendingIntent = chooserIntent
        persmissionResultLauncher.launch(Manifest.permission.CAMERA)
    }
}