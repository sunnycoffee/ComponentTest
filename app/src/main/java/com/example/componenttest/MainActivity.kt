package com.example.componenttest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.api.ModuleApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_a.setOnClickListener {
            val api = ARouter.getInstance().build("/a/api").navigation() as ModuleApi
            api.call("login", mapOf("username" to "张三"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tv.text = tv.text.toString() + it + "\n\r"
                }, {
                    tv.text = tv.text.toString() + it + "\n\r"
                })
        }

        btn_b.setOnClickListener {
            val api = ARouter.getInstance().build("/b/api").navigation() as ModuleApi
            api.call("login", mapOf("username" to "李四"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tv.text = tv.text.toString() + it + "\n\r"
                }, {
                    tv.text = tv.text.toString() + it + "\n\r"
                })
        }

        btn_go_a.setOnClickListener {
            ARouter.getInstance().build("/a/a1").navigation()
        }
        btn_go_b.setOnClickListener {
            ARouter.getInstance().build("/b/b1").navigation(this)
        }
    }
}

