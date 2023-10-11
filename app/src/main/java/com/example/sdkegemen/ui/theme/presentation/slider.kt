package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R

@Composable
fun SliderExample(modifier: Modifier) {
    var sliderValue by remember { mutableStateOf(0) }

    Column(

        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = stringResource(id =R.string.slider),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp)
        Text(text = "$sliderValue",

            textAlign = TextAlign.End,
            modifier = Modifier.offset(x=340.dp, y = 25.dp))
    }
        Slider(
            value = sliderValue.toFloat(),
            onValueChange = { newValue ->
                sliderValue = newValue.toInt()

            },
            valueRange = 0f..100f, // Range for the slider values
            steps = 99, // Number of steps or increments
            modifier = Modifier.padding(horizontal = 16.dp)

        )



    }

