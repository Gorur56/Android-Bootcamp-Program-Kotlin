package com.example.hiltkullanimi.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //Uygulamamızı temsil eder.
class HiltApplication : Application() {
    //di: dependency injection
}