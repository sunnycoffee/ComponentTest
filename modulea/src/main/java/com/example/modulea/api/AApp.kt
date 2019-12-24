package com.example.modulea.api

import android.app.Application
import android.util.Log
import com.example.common.IApp

/**
 *
 * @author kongfei
 */
class AApp : IApp {

    override fun onCreate(app: Application) {
        Log.d("moduleA", "模块A 初始化")
    }
}