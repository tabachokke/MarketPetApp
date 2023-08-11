package com.example.marketpetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.userLogin)
        val userEmail: EditText = findViewById(R.id.userEmail)
        val userPass: EditText = findViewById(R.id.userPass)
        val button: Button = findViewById(R.id.buttonReg)
        val linkToAuth: TextView = findViewById(R.id.linkToAuth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPass.text.toString().trim()

            if (login == "" || email == "" || password == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)

                val db = DBHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен" , Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

            }
        }
    }
}