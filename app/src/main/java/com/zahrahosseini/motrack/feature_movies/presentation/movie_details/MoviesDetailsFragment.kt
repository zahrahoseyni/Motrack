package com.zahrahosseini.motrack.feature_movies.presentation.movie_details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.zahrahosseini.motrack.core.utils.view.handleExceptions
import com.zahrahosseini.motrack.core.utils.view.showToast
import com.zahrahosseini.motrack.feature_movies.presentation.MoviesViewModel
import com.zahrahosseini.motrack.feature_movies.presentation.movie_details.compose.MovieDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private val viewModel: MoviesViewModel by activityViewModels()
    private lateinit var mContext: Context

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = requireContext()

        lifecycleScope.launch {
            launch {
                viewModel.errorMessage.collect {
                    mContext.showToast(it)
                }
            }
            launch {
                viewModel.errorException.collectLatest {
                    mContext.handleExceptions(it)
                }
            }

        }
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