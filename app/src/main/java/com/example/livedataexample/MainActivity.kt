package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


/*
* First go and watch "view model example". On that example , you can see that after every button click, we had to update the value in textview by
  calling the "setText()".
* By can do this using Livedata where it will have lifecycle aware and it will observe the lifecycle owner and when ever, there will be any update
  in the owner, it will notify you and you can do whatever you want to do.
*/

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainViewModel
    private val btn:Button
        get()=findViewById(R.id.btn)
    private val tv:TextView
        get() = findViewById(R.id.tv)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this, MainViewModelFactory(1))[MainViewModel::class.java]
        viewModel.factsLiveData.observe(this) {
            tv.text = it
        }
        //viewModel.factsLiveData.value="10"
        btn.setOnClickListener {
            viewModel.updateData()
        }
    }
}