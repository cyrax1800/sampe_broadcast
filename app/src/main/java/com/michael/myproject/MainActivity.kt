package com.michael.myproject

import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.michael.myproject.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val mUsers: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    init {
        loadUsers()
    }

    fun getUsers(): LiveData<List<String>> {
        return mUsers
    }

    fun getUserCount(): Int {
        return mUsers.value?.size ?: 0
    }

    private fun loadUsers() {
        // do async operation
        mUsers.value = listOf("user0", "user1")
    }

    fun addUser(user: String) {
        mUsers.value = mUsers.value.orEmpty() + listOf(user)
    }
}

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.addItemButton.setOnClickListener {
            val intent = Intent(applicationContext, Receiver::class.java)
            sendBroadcast(intent)

            finish()
//            Handler(this.mainLooper).postDelayed(this::finish, 200L)
        }
    }

    override fun onResume() {
        super.onResume()

        val intent = Intent(applicationContext, Receiver::class.java)
        sendBroadcast(intent)

        finish()
    }
}

