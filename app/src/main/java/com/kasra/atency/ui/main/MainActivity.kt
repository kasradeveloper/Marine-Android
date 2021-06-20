package com.kasra.atency.ui.main
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bilerplatemvvm.R
import com.kasra.atency.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeItems()

    }

    override fun observeItems() {
        TODO("Not yet implemented")
    }

}