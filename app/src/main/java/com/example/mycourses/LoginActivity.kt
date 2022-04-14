package com.example.mycourses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        tvNewUser.setOnClickListener { 
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPass.text.toString()
            if(email.isEmpty()||password.isEmpty())
            {
                Toast.makeText(LoginActivity@this,"please enter your credential",Toast.LENGTH_SHORT).show()
            }else{
                login(edtEmail.text.toString(),edtPass.text.toString());
            }


        }
    }

    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    finish()
                    startActivity(Intent(this,AddCourseActivity::class.java))
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this,"user does not exist", Toast.LENGTH_SHORT).show()
                }
            }
    }
}