package com.quy.livedatakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        val model: NameModel = ViewModelProviders.of(this).get(NameModel::class.java);
////        model.currentName.observe(this, Observer { name -> hello_world.text = name })
//    }

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            supportFragmentManager.beginTransaction()
                .replace(R.id.containerOne, FragmentOne.newInstance())
                .commitNow()



            supportFragmentManager.beginTransaction()
                .replace(R.id.containerTwo, FragmentTwo.newInstance())
                .commitNow()



        /**
         *  create view model with activity context
         */
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        viewModel.data().observe(this, Observer {
            Toast.makeText(this, "From Activity $it", Toast.LENGTH_SHORT).show()
        })
    }

}