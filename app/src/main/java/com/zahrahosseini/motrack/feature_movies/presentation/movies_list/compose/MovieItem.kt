package com.zahrahosseini.motrack.feature_movies.presentation.movies_list.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.motrack.core.presentation.design_system.theme.moTrackColors
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MovieItem

@Composable
fun MovieItem(
    movie: MovieItem, modifier: Modifier = Modifier, onMovieItemClicked: (movieId: Int) -> Unit
) {

    ConstraintLayout(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onMovieItemClicked(movie.id)
            }
    ) {
        val (txtTitle, txtReleaseDate, txtVoteAvg) = createRefs()

        val startGuideline = createGuidelineFromStart(8.dp)
        val topGuideline = createGuidelineFromTop(8.dp)

        Text(
            text = movie.title,
            modifier = Modifier.constrainAs(txtTitle) {
                top.linkTo(topGuideline)
                start.linkTo(startGuideline)

            },
            color = MaterialTheme.moTrackColors.designSystem.Neutral45,
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = movie.releaseDate,
            modifier = Modifier.constrainAs(txtReleaseDate) {
                top.linkTo(txtTitle.bottom, 8.dp)
                start.linkTo(startGuideline)
            },
            color = MaterialTheme.moTrackColors.designSystem.Neutral35,
            style = MaterialTheme.typography.bodySmall
        )


        Text(
            text = movie.voteAvg.toString(),
            modifier = Modifier.constrainAs(txtVoteAvg) {
                top.linkTo(txtReleaseDate.bottom, 8.dp)
                start.linkTo(startGuideline)
            },
            color = MaterialTheme.moTrackColors.designSystem.Neutral35,
            style = MaterialTheme.typography.bodySmall
        )

    }
}