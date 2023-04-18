package com.zahrahosseini.motrack.feature_movies.presentation.movies_list

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.motrack.core.presentation.design_system.theme.moTrackColors
import com.zahrahosseini.motrack.feature_movies.domain.entity.Movie

@Composable
fun MovieItem(
    movie: Movie, modifier: Modifier = Modifier,
) {

    ConstraintLayout(modifier = modifier) {
        val (txtTitle, txtOriginalTitle, txtVoteAvg, txtVoteCount, txtOriginLanguage) = createRefs()

        val startGuideline = createGuidelineFromStart(8.dp)
        val topGuideline = createGuidelineFromTop(8.dp)

        Text(
            text = movie.title,
            modifier = modifier.constrainAs(txtTitle) {
                top.linkTo(topGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            color = MaterialTheme.moTrackColors.designSystem.Neutral45,
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = movie.originalTitle,
            modifier = modifier.constrainAs(txtOriginalTitle) {
                top.linkTo(txtTitle.bottom, 8.dp)
                start.linkTo(startGuideline)
            },
            color = MaterialTheme.moTrackColors.designSystem.Neutral35,
            style = MaterialTheme.typography.displayMedium
        )


        Text(
            text = movie.voteAvg.toString(),
            modifier = modifier.constrainAs(txtVoteAvg) {
                top.linkTo(txtOriginalTitle.bottom, 8.dp)
                start.linkTo(startGuideline)
            },
            color = MaterialTheme.moTrackColors.designSystem.Neutral35,
            style = MaterialTheme.typography.displayMedium
        )

    }
}