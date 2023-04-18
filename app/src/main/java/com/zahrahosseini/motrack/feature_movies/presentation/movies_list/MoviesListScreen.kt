package com.zahrahosseini.motrack.feature_movies.presentation.movies_list

import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.motrack.R

@Composable
fun MoviesListScreen() {

    ConstraintLayout {
        val (txtHeader, cmpList) = createRefs()

        Text(
            modifier = Modifier.constrainAs(txtHeader) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            text = stringResource(id = R.string.txt_header),
            color = Color.Black,
            style = TextStyle(fontSize = 20.sp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            item {
                MovieItem()
            }
        }
    }
}