package com.example.modulea.api

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.modulea.R
import kotlinx.android.synthetic.main.activity_a1.*

/**
 *
 * @author kongfei
 */
@Route(path = "/a/a1")
class A1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a1)
        btn.setOnClickListener {
            ARouter.getInstance().build("/b/b1").navigation(this)
        }
    }


}