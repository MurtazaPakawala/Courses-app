package com.example.mycourses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.edtEmail
import kotlinx.android.synthetic.main.activity_sign_up.edtPass

class SignUpActivity : AppCompatActivity() {
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        
        mAuth = FirebaseAuth.getInstance()
        tvOldUser.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        btnSign.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPass.text.toString()
            val confirmpass = edtConfirmPass.text.toString()
            if(!password.equals(confirmpass))
            {
                Toast.makeText(SignUpActivity@this,"your password do not match", Toast.LENGTH_SHORT).show()
            }
            else if(password.isEmpty()||confirmpass.isEmpty()||email.isEmpty())
            {
                Toast.makeText(SignUpActivity@this,"please enter your credential",Toast.LENGTH_SHORT).show()
            }
            else
            {
                signup(email,password);
            }
        }
    }

    private fun signup(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    finish()
                    startActivity(Intent(this,MainActivity::class.java))

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("main", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(SignUpActivity@this,"error signing you",Toast.LENGTH_SHORT).show()
                }
            }
    }
}