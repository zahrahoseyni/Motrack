package com.zahrahosseini.motrack.core.presentation.design_system.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.zahrahosseini.motrack.core.presentation.design_system.theme.moTrackColors

fun Modifier.bgRounded20WhiteStrokeNeutral15() = composed {
    this.then(
        this
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.moTrackColors.designSystem.Neutral15,
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                color = MaterialTheme.moTrackColors.designSystem.Neutral00,
            )
    )
}