package com.farroos.academy.ui.detail

import com.farroos.academy.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailCourseViewModelTest{
    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId


    @Before
    fun setUp(){
        viewModel = DetailCourseViewModel()
        viewModel.selectedCourse(courseId)
    }

    @Test
    fun getCourse(){
        viewModel.selectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    @Test
    fun getModules(){
        val modulesEntities = viewModel.getModules()
        assertNotNull(modulesEntities)
        assertEquals(7, modulesEntities.size.toLong())
    }
}