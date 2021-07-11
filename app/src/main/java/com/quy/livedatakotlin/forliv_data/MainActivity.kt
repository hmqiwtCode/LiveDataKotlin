package com.quy.livedatakotlin.forliv_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.quy.livedatakotlin.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val viewModel = ViewModelProviders.of(this).get(MediatorCustom::class.java)


        viewModel.livedata1.observe(this, Observer {t ->
            tx1.text = t
        })

        btn.setOnClickListener {
            viewModel.livedata1.value = edt1.text.toString()
        }

        viewModel.livedata2.observe(this, Observer {
            tx2.text = it
        })

        btn2.setOnClickListener {
            viewModel.livedata2.value = tx2.text.toString()
        }



    }


}