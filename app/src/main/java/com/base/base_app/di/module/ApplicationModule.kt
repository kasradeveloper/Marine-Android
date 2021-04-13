package com.base.base_app.di.module

import android.content.Context
import com.base.base_app.data.AppDataManager
import com.base.base_app.data.AppDataManagerImpl
import com.base.base_app.data.network.ApiServices
import com.base.base_app.data.prefrences.AppPrefrencesImpl

import com.base.base_app.data.network.ApiHelper
import com.base.base_app.data.network.ApiHelperImpl
import com.base.base_app.data.prefrences.AppPrefrencesHelper
import com.base.bime.data.room.ApplicationDB
import com.base.bime.data.room.DataBaseHelper
import com.base.bime.data.room.DataBaseImpl
import com.example.bilerplatemvvm.BuildConfig

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @Provides
    fun provideBaseUrl() =BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttp():OkHttpClient{
        val loggingInterceptor=HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,baseUrl:String):Retrofit=
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
//            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiServices =retrofit.create(ApiServices::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper =apiHelperImpl

    @Provides
    @Singleton
    fun prividePrefrences(appPrefrencesImpl: AppPrefrencesImpl): AppPrefrencesHelper =appPrefrencesImpl

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): ApplicationDB = ApplicationDB.getDataBase(context)

    @Provides
    @Singleton
    fun provideDbImplementation(dataBaseImpl: DataBaseImpl): DataBaseHelper =dataBaseImpl

    @Provides
    @Singleton
    fun provideAppDataManger(appDataManagerImpl: AppDataManagerImpl): AppDataManager =appDataManagerImpl
}