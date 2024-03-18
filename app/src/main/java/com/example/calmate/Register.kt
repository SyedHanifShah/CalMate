package com.example.calmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Register : AppCompatActivity() {

    private lateinit var personNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmEditText: EditText
    private lateinit var register_btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        personNameEditText = findViewById(R.id.personName)
        emailEditText = findViewById(R.id.email_address)
        passwordEditText = findViewById(R.id.password)
        confirmEditText = findViewById(R.id.Edittext_confrimpassword)
        register_btn2 = findViewById(R.id.register_btn2)

        register_btn2.setOnClickListener {
            val name = personNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.toString()
            val confirmPassword = confirmEditText.text.toString()

            if(isValidRegistration(name, email, password, confirmPassword)){
                Toast.makeText(this, "Registration successfull!!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CalculateCalories::class.java)
                startActivity(intent)
                finish()
        }else{
                Toast.makeText(this, "Invalid registration details", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun isValidRegistration(name: String, email: String, password: String, confirmPassword: String): Boolean{
        return name.isNotEmpty() && email.isNotEmpty() && isValidEmail(email) && password.isNotEmpty() && confirmPassword.isNotEmpty() && password == confirmPassword
    }

    private fun isValidEmail(email: String): Boolean{
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}