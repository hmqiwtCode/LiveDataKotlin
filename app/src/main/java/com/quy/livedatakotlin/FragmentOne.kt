package com.quy.livedatakotlin

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_one.view.*

class FragmentOne : Fragment() {

    companion object {
        fun newInstance() = FragmentOne()
    }

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_one, container, false)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }

             activity?.let { viewModel.data().observe(it, Observer<String>{ item ->
            if (!item.isBlank()){
                Log.d("FRAGMENT A", this.toString());
                Log.d("SEE LOG ITEM",item);
                rootView.message.text = item
            }
        }) }

        rootView.post_button.setOnClickListener {
            val input = rootView.input_one.text.toString()
            if (!input.isBlank()) {
                viewModel.updateData(input)
            } else {
                ToastUtil.show(context, "Please enter message to post")
            }
        }

        return rootView
    }


}