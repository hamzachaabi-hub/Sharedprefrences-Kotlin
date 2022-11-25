package com.example.sharedprefernces

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.sharedprefernces.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding

    lateinit var btnSave : Button
    lateinit var btnLoad: Button
    lateinit var edtUsername :TextView
    lateinit var edtEmail : TextView
    lateinit var checkBox: CheckBox

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
        checkBox = findViewById(R.id.checkBox)

        binding.apply {
            btnSave.setOnClickListener {
                val userName = edtUsername.text.toString()
                val email = edtEmail.text.toString()

                if (checkBox.isChecked) {

                    editor.apply {
                        putString("user_name",userName)
                        putString("email",email)
                        apply()
                    }
                } else {
                    val editor: SharedPreferences.Editor = sharedPref.edit()
                   // sharedPref = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                    editor.clear()
                    editor.commit()
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
