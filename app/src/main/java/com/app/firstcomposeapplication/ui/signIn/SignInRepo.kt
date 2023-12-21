package com.app.firstcomposeapplication.ui.signIn

import com.app.firstcomposeapplication.ui.UserApi
import com.app.firstcomposeapplication.ui.UserDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignInRepo @Inject constructor(var api: UserApi){

    fun callSignInApi():Flow<List<UserDataItem>> = flow {
        emit(api.getUserById())
    }
}