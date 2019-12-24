package com.example.moduleb

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.api.ModuleApi
import io.reactivex.Observable

/**
 *
 * 模块B api
 *
 * @author kongfei
 */
@Route(path = "/b/api", name = "模块B api")
@Suppress("unused")
class ModuleBApi : ModuleApi {

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
            Log.d("ModuleB", "方法调用失败：$name")
            Observable.create<String> { it.onError(e) }
        }
    }


    private fun login(params: Map<String, *>?): Observable<String> {
        return Observable.create<String> {
            Thread.sleep(2000)
            it.onNext("B-登陆成功:${params?.get("username")}")
        }
    }

    private fun getUserInfo(params: Map<String, *>?): Observable<String> {
        return Observable.create<String> {
            Thread.sleep(2000)
            it.onNext("B-获取用户信息成功:${params?.get("username")}")
        }
    }

}