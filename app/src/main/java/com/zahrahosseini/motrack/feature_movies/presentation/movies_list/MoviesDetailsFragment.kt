package com.zahrahosseini.motrack.feature_movies.presentation.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.fragment.app.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zahrahosseini.motrack.feature_movies.presentation.MoviesViewModel
import com.zahrahosseini.motrack.feature_movies.presentation.movies_list.compose.MovieDetails
import com.zahrahosseini.motrack.feature_movies.presentation.movies_list.compose.MoviesListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUiComponent()
        initUiListener()
        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
             //   MovieDetails()
            }
        }
    }

    private fun initUiComponent() {
    }

    private fun initUiListener() {
    }

    private fun initObservers() {
    }
}