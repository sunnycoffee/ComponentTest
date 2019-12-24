package com.example.common.api

import com.alibaba.android.arouter.facade.template.IProvider
import io.reactivex.Observable

/**
 * 模块接口
 *
 * @author kongfei
 */
interface ModuleApi : IProvider {

    fun call(name: String, params: Map<String, *>?): Observable<String>
}