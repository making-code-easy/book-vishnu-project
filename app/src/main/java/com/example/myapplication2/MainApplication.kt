package com.example.myapplication2

import android.app.Application
import com.example.myapplication2.di.component.BaseAppComponent
import com.example.myapplication2.di.component.DaggerBaseAppComponent
import com.example.myapplication2.di.module.BaseAppModule

class MainApplication : Application() {
    fun getBaseComponent(): BaseAppComponent {
        return DaggerBaseAppComponent.builder().baseAppModule(BaseAppModule(this)).build()
    }
}