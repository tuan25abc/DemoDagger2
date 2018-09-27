package com.example.tuannguyen.demodagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tuannguyen.demodagger2.model.Info
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.text = info.text
    }
}