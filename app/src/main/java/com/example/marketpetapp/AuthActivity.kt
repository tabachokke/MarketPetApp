package com.example.marketpetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = this.findViewById(R.id.userLogiAuth)
        val userPass: EditText = this.findViewById(R.id.userPassAuth)
        val button: Button = this.findViewById(R.id.buttonAuth)

        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPass.text.toString().trim()

            if (login == "" || password == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val db = DBHelper(this, null)
                val isAuth = db.getUser(login, password)
                if (isAuth){
                    Toast.makeText(this, "Пользователь $login авторизован" , Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)

                } else
                    Toast.makeText(this, "Пользователь $login не авторизован" , Toast.LENGTH_LONG).show()
            }
        }
    }
}