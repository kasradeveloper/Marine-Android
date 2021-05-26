package com.base.base_app.ui.main

import android.graphics.Bitmap
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.base_app.data.AppDataManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityScoped
class MainViewModel @ViewModelInject constructor(
    private val appDataManagerImpl: AppDataManager

) : ViewModel() {
    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.IO) {

            }
        }
    }
    fun getUserInfoApiCall(profilePictures: CircleImageView?) {
//        getMvpView().showProgress();
        AppDataManager.getInstance(getMvpView().getContext())
            .getPersonInfoApiCall(object : Callback<UserInfo?> {
                override fun onResponse(call: Call<UserInfo?>, response: Response<UserInfo?>) {
                    if (response.isSuccessful()) {
                        assert(response.body() != null)
                        if (!getPrefrencesPresenter().getImageName()
                                .equalsIgnoreCase(response.body().getAddress().getImageName())
                        ) {
                            getPrefrencesPresenter().saveImageName(
                                response.body().getAddress().getImageName()
                            )
                            setProfilePictures(profilePictures)
                        } else {
                            Glide.with(getMvpView().getContext().getApplicationContext())
                                .asBitmap()
                                .load(Commons.StringToBitMap(getPrefrencesPresenter().getImageByte()))
                                .dontTransform()
                                .centerCrop()
                                .placeholder(R.drawable.icon_user)
                                .dontAnimate()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into<Target<Bitmap>>(profilePictures)
                        }
                        getMvpView().hideProgress()
                    } else {
                        try {
                            val jsonObject = JSONObject(response.errorBody().toString())
                            getMvpView().hideProgress()
                            getMvpView().showErrorMessage(jsonObject["Message"] as String)
                            //                        Glide.with(getMvpView().getContext())
//                                .asBitmap()
//                                .load(Commons.StringToBitMap(getPrefrencesPresenter().getImageByte()))
//                                .dontTransform()
//                                .placeholder(R.drawable.icon_user)
//                                .dontAnimate()
//                                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                                .into(profilePictures);
                        } catch (e: JSONException) {
                            Sentry.captureException(e)
                            getMvpView().hideProgress()
                        }
                    }
                }

                override fun onFailure(call: Call<UserInfo?>, t: Throwable) {
                    getMvpView().hideProgress()
                    getMvpView().showErrorMessage(
                        getMvpView().getContext().getResources().getString(R.string.msg_error)
                    )
                    Glide.with(getMvpView().getContext().getApplicationContext())
                        .asBitmap()
                        .load(Commons.StringToBitMap(getPrefrencesPresenter().getImageByte()))
                        .dontTransform()
                        .placeholder(R.drawable.icon_user)
                        .dontAnimate()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into<Target<Bitmap>>(profilePictures)
                }
            })
    }
}

