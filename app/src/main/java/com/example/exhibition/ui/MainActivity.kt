package com.example.exhibition.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.exhibition.R
import com.example.exhibition.main.BaseActivity
import com.example.exhibition.main.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity: BaseActivity<MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModel()
    private var isDrawerFixed: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isDrawerFixed = resources.getBoolean(R.bool.isDrawerFixed)
        if (!isDrawerFixed) {
            val toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            drawer_layout.addDrawerListener(toggle)
            toggle.syncState()
        }

    }
}
