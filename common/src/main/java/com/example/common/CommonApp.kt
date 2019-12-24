package com.example.common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 *
 * 公共模块生命周期实现
 *
 * @author kongfei
 */
class CommonApp : IApp {

    override fun onCreate(app: Application) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(app)
    }
}