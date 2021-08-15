package com.kasra.atency.ui.main

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.kasra.atency.data.model.Info.CellInfoModel
import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.model.update.CheckUpdateResponseModel
import com.kasra.atency.data.model.workplace.Country
import com.kasra.atency.data.repository.user.UserRepository
import com.kasra.atency.utility.ANDROID
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.MyDateConverts
import com.kasra.atency.utility.getUniquePsuedoID
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.sentry.Sentry
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    @ApplicationContext val context: Context
) : ViewModel() {
    private val mutablePermissions =
        MutableLiveData<List<PermissionResponseModel>>()
    val permissions: LiveData<List<PermissionResponseModel>> = mutablePermissions
    private val mutableuserInfo =
        MutableLiveData<UserInfo>()
    val userInfo: LiveData<UserInfo> = mutableuserInfo
    private val mutableBadgeNumber = MutableLiveData<Int>()
    val badgeNumber: LiveData<Int> = mutableBadgeNumber
    private val mutableLogout = MutableLiveData<CustomResponse<JsonObject>>()
    val logout: LiveData<CustomResponse<JsonObject>> = mutableLogout
    private val mutableCheckUpdate = MutableLiveData<CustomResponse<CheckUpdateResponseModel>>()
    val checkUpdate: LiveData<CustomResponse<CheckUpdateResponseModel>> = mutableCheckUpdate
    val mutableupdateCell = MutableLiveData<CustomResponse<JsonObject>>()
    val updateCell: LiveData<CustomResponse<JsonObject>> = mutableupdateCell

    fun getUserPermission() {
        viewModelScope.launch {
            userRepository.getPermissions(0, 100)
                .collect {
                    mutablePermissions.postValue(it)
                }
        }
    }
    fun getBadgeMessage() {
        viewModelScope.launch {
            userRepository.getBadgeMessage()
                .collect {
                    if (it.status == CustomResponse.Status.SUCCESS) {
                        val jsonObject = JSONObject(it.data.toString())
                        mutableBadgeNumber.postValue(jsonObject.getString("IValue").toInt())
                    }
                }
        }
    }

    fun getUserInfo() {
        viewModelScope.launch {
            userRepository.getUserInfoLocal().collect {
                mutableuserInfo.value = it
            }
        }
    }

    fun logoutHandler() {
        viewModelScope.launch {
            val cellInfoModel = CellInfoModel()
            cellInfoModel.isActive = false
            var pInfo: PackageInfo? = null
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
            val currentLocalTime = calendar.time
            val date: DateFormat = SimpleDateFormat("z", Locale.getDefault())
            val localtime = date.format(currentLocalTime)
            try {
                pInfo = context.packageManager
                    .getPackageInfo(context.packageName, 0)
            } catch (e: PackageManager.NameNotFoundException) {
                Sentry.captureException(e)
            }
            var version: String? = null
            if (pInfo != null) {
                version = pInfo.versionName
            }
            cellInfoModel.appVersion = version
            cellInfoModel.brand = Build.MODEL
            val telephonyManager: TelephonyManager =
                context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            cellInfoModel.country = Country(telephonyManager.simCountryIso)
            cellInfoModel.iMEI = getUniquePsuedoID()
            cellInfoModel.date = MyDateConverts.convertDateToString(Date())
            cellInfoModel.operationSystem = ANDROID
            cellInfoModel.operationSystemVersion = Build.VERSION.RELEASE
            cellInfoModel.timezone = localtime
            userRepository.logoutCall(cellInfoModel)
                .collect {
                    userRepository.removeAll()
                }
        }
    }

    fun checkUpdate() {
        var version = "0"
        val pInfo = context.packageManager
            .getPackageInfo(context.packageName, 0)
        version = pInfo.versionName
        viewModelScope.launch {
            userRepository.checkForUpdate(version)
                .collect {
                    mutableCheckUpdate.postValue(it)
                }
        }
    }

    fun updateCellInfo(token: String) {
        val cellInfoModel = CellInfoModel()
        var pInfo: PackageInfo? = null
        try {
            pInfo = context.packageManager
                .getPackageInfo(context.packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            Sentry.captureException(e)
        }
        var version: String? = null
        if (pInfo != null) {
            version = pInfo.versionName
        }
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val currentLocalTime = calendar.time
        val date: DateFormat = SimpleDateFormat("z", Locale.getDefault())
        val localtime = date.format(currentLocalTime)

        cellInfoModel.isActive = true
        cellInfoModel.appVersion = version
        cellInfoModel.brand = Build.MODEL
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        cellInfoModel.country = Country(telephonyManager.simCountryIso)
        cellInfoModel.iMEI = getUniquePsuedoID()
        cellInfoModel.date = MyDateConverts.convertDateToString(Date())
        cellInfoModel.operationSystem = "Android"
        cellInfoModel.operationSystemVersion = Build.VERSION.RELEASE
        cellInfoModel.timezone = localtime
        userRepository.saveDeviceID(getUniquePsuedoID())
        cellInfoModel.pushId=token
        viewModelScope.launch {
            userRepository.updateCellInfo(cellInfoModel)
                .collect {
                    mutableupdateCell.postValue(it)
                }
        }

    }

}

