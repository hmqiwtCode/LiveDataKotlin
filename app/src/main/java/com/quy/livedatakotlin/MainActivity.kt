package com.quy.livedatakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model: NameModel = ViewModelProviders.of(this).get(NameModel::class.java);
        model.currentName.observe(this, Observer { name -> hello_world.text = name })
        button.setOnClickListener(View.OnClickListener { item -> model.setPar() } )
    }
}