package com.zahrahosseini.motrack.feature_movies.presentation.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.zahrahosseini.motrack.feature_movies.presentation.MoviesViewModel
import com.zahrahosseini.motrack.feature_movies.presentation.movie_details.compose.MovieDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private val viewModel: MoviesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieDetails(viewModel)
            }
        }
    }



}