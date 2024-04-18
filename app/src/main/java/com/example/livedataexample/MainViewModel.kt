package com.example.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private var counter: Int) : ViewModel() {
    /*
    val factsLiveData=MutableLiveData<String>(counter.toString())

    here if we use MutableLiveData then, we are allowed to change there value from everywhere as:
     viewModel.factsLiveData.value="10"
    This can leads to problem. to overcome this we can
    make it private , but we can't access it in MainActivity. so we should make it "LiveData", which is immutable. But while updating data, we will
    not be able to change it. So , we will use both the MutableLiveData and LiveData in two different variable as:
     */
    private val factsLiveDataObjects=MutableLiveData<String>(counter.toString())
    val factsLiveData:LiveData<String>
        get()=factsLiveDataObjects
    // This "get()" is a custom getter function for the property factsLiveData. Whenever factsLiveData is accessed, this getter will be invoked.
    // now we can't change the value of factsLiveData from another class
    fun updateData(){
        counter+=1
        factsLiveDataObjects.value= counter.toString()
    }
}