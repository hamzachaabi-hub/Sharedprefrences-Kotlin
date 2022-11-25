package com.example.sharedprefernces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.sharedprefernces.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding

    lateinit var btnSave : Button
    lateinit var btnLoad: Button
    lateinit var edtUsername :TextView
    lateinit var edtEmail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor =sharedPref.edit()

        edtUsername = findViewById(R.id.edtUsername)
        edtEmail = findViewById(R.id.edtEmail)
        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)

        binding.apply {
            btnSave.setOnClickListener {
                val userName = edtUsername.text.toString()
                val email = edtEmail.text.toString()

                editor.apply {
                    putString("user_name",userName)
                    putString("email",email)
                    apply()
                }
            }

            btnLoad.setOnClickListener {

                val userName = sharedPref.getString("user_name",null)
                val email = sharedPref.getString("email",null)

                tvUsername.text = userName
                tvEmail.text= email

            }
        }

    }
}
