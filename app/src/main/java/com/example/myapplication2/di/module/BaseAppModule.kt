package com.example.myapplication2.di.module

import android.app.Application
import android.content.Context
//import com.example.myapplication2.common.CoroutineDispatchers
//import com.example.myapplication2.common.CoroutineDispatchersProvider
import com.example.myapplication2.di.qualifier.ApplicationContext
import com.example.myapplication2.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class BaseAppModule(private var application: Application) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun providesApplicationContext(): Context {
        return application.applicationContext
    }
}