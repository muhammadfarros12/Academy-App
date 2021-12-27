package com.farroos.academy.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.farroos.academy.R
import com.farroos.academy.data.CourseEntity
import com.farroos.academy.databinding.FragmentBookmarkBinding


class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[BookmarkViewModel::class.java]
            val courses = viewModel.getBookmarks()

            //val courses = DataDummy.generateDummyCourses()
            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with(binding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }

    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, course.title))
                .startChooser()
        }
    }

}