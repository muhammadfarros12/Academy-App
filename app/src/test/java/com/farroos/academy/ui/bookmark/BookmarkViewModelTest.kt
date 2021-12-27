package com.farroos.academy.ui.bookmark

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getCourses() {
        val courseBookmarks = viewModel.getBookmarks()
        assertNotNull(courseBookmarks)
        assertEquals(5, courseBookmarks.size)
    }


}