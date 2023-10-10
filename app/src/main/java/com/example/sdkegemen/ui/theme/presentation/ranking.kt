package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.consumeDownChange
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.sdkegemen.R
import kotlin.math.roundToInt


@Composable
fun Ranking(
    letter: String,
) {
    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }
    val zIndex = remember { mutableStateOf(0f) }


    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .width(344.dp)
            .height(60.dp)
            .offset { IntOffset(x = offsetX.value.roundToInt(), y = offsetY.value.roundToInt()) }
            .zIndex(zIndex.value)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    offsetY.value += dragAmount.y
                    zIndex.value = 1f
                }
            }
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter,
            modifier = Modifier.fillMaxSize().padding(16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp, horizontal = 20.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic
    )
}






