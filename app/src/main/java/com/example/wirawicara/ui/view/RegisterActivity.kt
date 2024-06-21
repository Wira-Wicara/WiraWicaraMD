package com.example.wirawicara.ui.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.wirawicara.ui.repository.Result
import com.example.wirawicara.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private var username: String = ""
    private var email: String = ""
    private var password: String = ""

    private val viewModel by viewModels<RegisterViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.isEnabled = false
        setupAction()

        binding.loginTV.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        binding.registerBtn.setOnClickListener {
            showLoading()
            binding.apply {
                email = emailRegister.text.toString().trim()
                password = passwordRegister.text.toString().trim()
            }

            viewModel.addNewUser(username, email, password).observe(this) { result ->
                when(result) {
                    is Result.Loading -> {
                        showLoading()
                    }
                    is Result.Error -> {
                        showToast(result.error)
                    }
                    is Result.Success -> {
                        onSuccess()
                        Log.d("INI RESPONSE", result.data.data.toString())
                    }
                }
            }
        }
    }

    private fun setupAction() {
        binding?.apply {
            emailRegister.addTextChangedListener(watcher)
            passwordRegister.addTextChangedListener(watcher)
        }
    }

    private fun onSuccess() {
        binding.progressBar.visibility = View.GONE
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setMyButtonEnabled() {
        val email = binding?.emailRegister
        val password = binding?.passwordRegister

        if (email?.text!!.isNotEmpty() && password?.text!!.isNotEmpty()) {
            binding?.registerBtn?.isEnabled = email?.error == null && password?.error == null
        }
        else {
            binding?.registerBtn?.isEnabled = false
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            setMyButtonEnabled()
        }

        override fun afterTextChanged(s: Editable?) {
            //
        }
    }
}
