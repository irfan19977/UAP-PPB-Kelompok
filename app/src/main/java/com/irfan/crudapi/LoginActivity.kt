package com.irfan.crudapi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    var username: EditText? = null
    var password: EditText? = null
    var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById<EditText>(R.id.login_username)
        password = findViewById<EditText>(R.id.login_password)
        loginButton = findViewById<Button>(R.id.buttonLogin)

        loginButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (username?.text.toString() == "irfan" && password?.text.toString() == "1234" ) {
                    Toast.makeText(this@LoginActivity, "Login Successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Login Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}