package com.quy.livedatakotlin.combinev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.quy.livedatakotlin.R
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.currentScore1.observe(this){
            tv1.text = it.first.toString() + "-----"  + it.second.toString()
        }

        button.setOnClickListener {
            viewModel.setFirstPlayerScore(ed1.text.toString().toInt())
            if (ed2.text.toString() != ""){
                viewModel.setSecondPlayerScore(ed2.text.toString().toInt())
            }

        }


    }
}