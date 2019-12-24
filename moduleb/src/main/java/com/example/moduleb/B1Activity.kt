package com.example.moduleb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_b1.*

/**
 *
 * @author kongfei
 */
@Route(path = "/b/b1")
class B1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b1)
        btn.setOnClickListener {
            ARouter.getInstance().build("/a/a1").navigation(this)
        }

    }
}