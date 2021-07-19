package com.kasra.atency.di.module

import android.content.Context
import com.example.bilerplatemvvm.BuildConfig
import com.kasra.atency.data.network.ApiHelper
import com.kasra.atency.data.network.ApiHelperImpl
import com.kasra.atency.data.network.ApiServices
import com.kasra.atency.data.network.OAuthInterceptor
import com.kasra.atency.data.prefrences.AppPrefrencesHelper
import com.kasra.atency.data.prefrences.AppPrefrencesImpl
import com.kasra.atency.data.repository.BaseRepository
import com.kasra.atency.data.repository.BaseRepositoryImpl
import com.kasra.atency.data.repository.user.UserRepository
import com.kasra.atency.data.repository.user.UserRepositoryImpl
import com.kasra.atency.data.repository.workplace.WorkPlaceRepository
import com.kasra.atency.data.repository.workplace.WorkPlaceRepositoryImpl
import com.kasra.atency.data.room.ApplicationDB
import com.kasra.bime.data.room.DataBaseHelper
import com.kasra.bime.data.room.DataBaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideBaseUrl() =BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttp(auth:OAuthInterceptor):OkHttpClient{
        val loggingInterceptor=HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(auth)
            .build()
    }
    @Provides
    @Singleton

    fun provideRetrofit(okHttpClient: OkHttpClient,baseUrl:String):Retrofit=
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
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
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository =userRepositoryImpl

    @Provides
    @Singleton
    fun provideWorkPlaceRepository(workPlaceRepositoryImpl: WorkPlaceRepositoryImpl): WorkPlaceRepository =workPlaceRepositoryImpl

    @Provides
    @Singleton
    fun provideBaseRepository(baseRepositoryImpl: BaseRepositoryImpl): BaseRepository =baseRepositoryImpl

    @Provides
    @Singleton
    fun provideAuthorization(appPrefrencesHelper: AppPrefrencesHelper):OAuthInterceptor{
        return OAuthInterceptor(appPrefrencesHelper)
    }
}