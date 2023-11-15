package com.example.mobile_midterm2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val userService = RetrofitClient.userService

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        viewModelScope.launch {
            try {
                val response = userService.getUsers()
                _users.value = response
                Log.d("UserViewModel", "Users loaded successfully")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error loading users", e)
            }
        }
    }
}