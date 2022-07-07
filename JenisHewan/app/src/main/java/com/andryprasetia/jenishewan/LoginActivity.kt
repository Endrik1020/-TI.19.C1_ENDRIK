package com.andryprasetia.jenishewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andryprasetia.jenishewan.databinding.ActivityLoginBinding
import com.andryprasetia.jenishewan.databinding.ActivityProfileBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{

            val datalogin = ModelLogin(binding.textPUserName.text.toString(), binding.textPPassword.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data",datalogin)
            startActivity(intent)
        }
    }
}