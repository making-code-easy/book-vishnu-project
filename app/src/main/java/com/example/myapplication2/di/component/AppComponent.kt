package com.example.myapplication2.di.component

import com.example.myapplication2.di.module.BookAppModule
import com.example.myapplication2.di.module.ViewModelModule
import com.example.myapplication2.di.scope.AppScope
import com.example.myapplication2.ui.MainActivity
import dagger.Component

@AppScope
@Component(
    modules = [BookAppModule::class, ViewModelModule::class],
    dependencies = [BaseAppComponent::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}