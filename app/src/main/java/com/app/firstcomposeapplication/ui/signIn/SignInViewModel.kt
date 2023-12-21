package com.app.firstcomposeapplication.ui.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.firstcomposeapplication.ui.UserDataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(var signInRepo: SignInRepo) : ViewModel(){

    private var mutableLiveData= MutableLiveData<List<UserDataItem>>()
    val liveData : LiveData<List<UserDataItem>> = mutableLiveData

    fun callSignInApi(){
       viewModelScope.launch {
           signInRepo.callSignInApi().collect{
               mutableLiveData.value = it
           }
       }
    }
}