package com.zahrahosseini.motrack.feature_movies.presentation.movies_list.compose


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.motrack.R
import com.zahrahosseini.motrack.core.presentation.design_system.shapes.bgRounded20WhiteStrokeNeutral15
import com.zahrahosseini.motrack.core.utils.ApiConstants.Companion.API_KEY
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListArg
import com.zahrahosseini.motrack.feature_movies.presentation.MoviesViewModel

@Composable
fun MoviesListScreen(
    viewModel: MoviesViewModel, onMovieItemClicked: () -> Unit
) {

    viewModel.getMoviesList(
        MoviesListArg(
            apiKey = API_KEY,
        )
    )
    val moviesList by viewModel.moviesResult.collectAsState()


    ConstraintLayout() {
        val (txtHeader, cmpList) = createRefs()

        val topGuideline = createGuidelineFromTop(16.dp)
        val startGuideline = createGuidelineFromStart(8.dp)

        Text(
            modifier = Modifier.constrainAs(txtHeader) {
                top.linkTo(topGuideline)
                start.linkTo(startGuideline)
            },
            text = stringResource(id = R.string.txt_header),
            color = Color.Black,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )

        LazyColumn(
            modifier = Modifier
                .constrainAs(cmpList) {
                    top.linkTo(txtHeader.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            moviesList.forEach { movie ->
                item {
                    MovieItem(
                        movie, modifier = Modifier
                            .bgRounded20WhiteStrokeNeutral15()
                    ) {
                        viewModel.selectedMovieId.value = it
                        onMovieItemClicked()
                    }
                }
            }

        }
    }
}