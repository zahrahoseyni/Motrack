package com.zahrahosseini.motrack.feature_movies.presentation.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.zahrahosseini.motrack.core.presentation.design_system.theme.moTrackColors
import com.zahrahosseini.motrack.core.utils.view.canNavigate
import com.zahrahosseini.motrack.core.utils.view.navigateSafe
import com.zahrahosseini.motrack.feature_movies.presentation.MoviesViewModel
import com.zahrahosseini.motrack.feature_movies.presentation.movies_list.compose.MoviesListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment() {

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
                MoviesListScreen(viewModel) {
                    navigate(MoviesListFragmentDirections.actionMoviesListFragmentToMoviesDetailsFragment())
                }
            }
        }
    }

    private fun navigate(directions: NavDirections, navOptions: NavOptions? = null) {
        if (canNavigate())
            navigateSafe(directions, navOptions)
    }

}