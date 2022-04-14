package com.example.mycourses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_course.*
import kotlinx.android.synthetic.main.activity_update_course.*


class UpdateCourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_course)


        edtCourseNameU.text = edtCourseName.text
        edtCourseInstructorU.text = edtCourseInstructor.text
        edtCourseLinkU.text = edtCourseLink.text
        edtCourseDescriptionU.text = edtCourseDescription.text



    }
}