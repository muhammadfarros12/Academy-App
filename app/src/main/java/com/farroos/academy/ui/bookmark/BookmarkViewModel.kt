package com.farroos.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.farroos.academy.data.CourseEntity
import com.farroos.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()

}