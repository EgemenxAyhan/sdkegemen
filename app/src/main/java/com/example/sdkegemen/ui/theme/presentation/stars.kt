package com.example.sdkegemen.ui.theme.presentation

import android.inputmethodservice.Keyboard
import android.service.autofill.Validators.or
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R

@Composable
fun Stars(modifier: Modifier) {
    val star: Painter = painterResource(id = R.drawable.staricon)
    val yellowstar: Painter = painterResource(id = R.drawable.stariconyellow)
    val state = remember { mutableStateOf(-1) }

    Text(
        text = stringResource(id = R.string.star),
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        for (number in 0..4) {
            val ordered = number < state.value || number == state.value


            Box(modifier = Modifier
                .padding(3.dp)
                .width(50.dp)
                .height(50.dp)
                .clickable {
                    if (state.value == number) {
                        state.value = -1

                    } else
                        state.value = number


                }) {


                Image(
                    painter = if (ordered) yellowstar else star,
                    contentDescription = "star",
                    modifier = Modifier
                        .size(50.dp)
                )

            }


        }


    }

}