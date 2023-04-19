package com.zahrahosseini.motrack.feature_movies.presentation.movie_details.compose

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.motrack.R
import com.zahrahosseini.motrack.core.presentation.design_system.theme.moTrackColors
import com.zahrahosseini.motrack.core.utils.ApiConstants.Companion.API_KEY
import com.zahrahosseini.motrack.core.utils.network.ApiResult
import com.zahrahosseini.motrack.core.utils.network.data
import com.zahrahosseini.motrack.core.utils.view.handleExceptions
import com.zahrahosseini.motrack.core.utils.view.showToast
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MoviesDetailsArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MovieItem
import com.zahrahosseini.motrack.feature_movies.presentation.MoviesViewModel

@Composable
fun MovieDetails(
    viewModel: MoviesViewModel
) {
    viewModel.getMovieDetails(
        MoviesDetailsArg(
            movieId = viewModel.selectedMovieId.value,
            apiKey = API_KEY
        )
    )

    val movie by viewModel.movieDetailsResult.collectAsState()

    movie?.let {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp)
        ) {

            val (txtHeader, txtTitle, txtReleaseDate, txtVoteAvg) = createRefs()

            val startGuideline = createGuidelineFromStart(8.dp)
            val topGuideline = createGuidelineFromTop(8.dp)


            Text(
                modifier = Modifier.constrainAs(txtHeader) {
                    top.linkTo(topGuideline)
                    start.linkTo(startGuideline)
                },
                text = stringResource(id = R.string.txt_header_details),
                color = Color.Black,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )

            movie?.let {
                Text(
                    text = it.title,
                    modifier = Modifier.constrainAs(txtTitle) {
                        top.linkTo(txtHeader.bottom, 16.dp)
                        start.linkTo(startGuideline)

                    },
                    color = MaterialTheme.moTrackColors.designSystem.Neutral45,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            movie?.let {
                Text(
                    text = it.releaseDate,
                    modifier = Modifier.constrainAs(txtReleaseDate) {
                        top.linkTo(txtTitle.bottom, 8.dp)
                        start.linkTo(startGuideline)
                    },
                    color = MaterialTheme.moTrackColors.designSystem.Neutral35,
                    style = MaterialTheme.typography.bodySmall
                )
            }


            Text(
                text = movie?.voteAvg.toString(),
                modifier = Modifier.constrainAs(txtVoteAvg) {
                    top.linkTo(txtReleaseDate.bottom, 8.dp)
                    start.linkTo(startGuideline)
                },
                color = MaterialTheme.moTrackColors.designSystem.Neutral35,
                style = MaterialTheme.typography.bodySmall
            )

        }
    }

}