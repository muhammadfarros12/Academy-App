package com.farroos.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.farroos.academy.data.CourseEntity
import com.farroos.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()

}