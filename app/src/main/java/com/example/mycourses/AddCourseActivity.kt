package com.example.mycourses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_course.*

class AddCourseActivity : AppCompatActivity() {
    private lateinit var db : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)


       btnAddCourse.setOnClickListener {
           val courseName = edtCourseName.text.toString()
           val courseInstructor = edtCourseInstructor.text.toString()
           val courseLink = edtCourseLink.text.toString()
           val courseDes = edtCourseDescription.text.toString()
           val courseId = courseName
           if(courseName.isEmpty() || courseDes.isEmpty() || courseInstructor.isEmpty() || courseLink.isEmpty())
           {
               //showing the message that please complete the information
           }
           else{
               db = FirebaseDatabase.getInstance().getReference()
               db.child(courseId).setValue(CourseClass(courseName,courseInstructor,courseLink,courseDes,courseId))

               Toast.makeText(this,"The course has been added", Toast.LENGTH_SHORT).show()
               startActivity(Intent(this,MainActivity::class.java))
               finish()
           }

       }

    }
}