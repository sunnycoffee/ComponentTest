package com.example.modulea.api

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.api.ModuleApi
import io.reactivex.Observable

/**
 *
 * @author kongfei
 */
@Route(path = "/a/api", name = "模块A api")
@Suppress("unused")
class ModuleAApi : ModuleApi {

    override fun init(context: Context?) {
    }

    @Suppress("UNCHECKED_CAST")
    override fun call(name: String, params: Map<String, *>?): Observable<String> {
        return try {
            javaClass
                .getDeclaredMethod(name, Map::class.java)
                .invoke(this, params) as Observable<String>
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("ModuleA", "方法调用失败：$name")
            Observable.create<String> { it.onError(e) }
        }
    }


    private fun login(params: Map<String, *>?): Observable<String> {
        return Observable.create<String> {
            Thread.sleep(2000)
            it.onNext("A-登陆成功:${params?.get("username")}")
        }
    }

    private fun getUserInfo(params: Map<String, *>?): Observable<String> {
        return Observable.create<String> {
            Thread.sleep(2000)
            it.onNext("A-获取用户信息成功:${params?.get("username")}")
        }
    }
}