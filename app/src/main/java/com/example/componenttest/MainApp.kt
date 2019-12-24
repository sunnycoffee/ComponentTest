package com.example.componenttest

import android.app.Application
import com.example.common.IApp
import java.util.*

/**
 *
 * @author kongfei
 */
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLoader
            .load(IApp::class.java)
            .forEach { it.onCreate(this) }
    }
}