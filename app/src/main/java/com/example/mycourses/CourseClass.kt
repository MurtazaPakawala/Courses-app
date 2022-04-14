package com.example.mycourses

class CourseClass {
    var courseName: String? = null
    var courseInstructor: String? = null
    var courseLink: String? = null
    var courseDescription: String? = null
    var courseId: String? = null

    constructor()

    constructor(
        courseName: String?,
        courseInstructor: String?,
        courseLink: String?,
        courseDescription: String?,
        courseId: String?
    ) {
        this.courseName = courseName
        this.courseInstructor = courseInstructor
        this.courseLink = courseLink
        this.courseDescription = courseDescription
        this.courseId = courseId
    }

}