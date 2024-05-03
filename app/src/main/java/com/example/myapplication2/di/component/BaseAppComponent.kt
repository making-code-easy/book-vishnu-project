package com.example.myapplication2.di.component

import android.content.Context
import com.example.myapplication2.di.module.BaseAppModule
import com.example.myapplication2.di.qualifier.ApplicationContext
import com.example.myapplication2.di.scope.ApplicationScope
import dagger.Component
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [BaseAppModule::class])
interface BaseAppComponent {

    @ApplicationContext
    fun getApplicationContext(): Context

    fun getRetrofit(): Retrofit


}