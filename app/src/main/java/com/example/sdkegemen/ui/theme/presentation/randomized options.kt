package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun RandomizedOptions(modifier: Modifier) {
    val state = remember{ mutableStateOf(-1) }
    val choices = listOf("A", "C", "B", "D")
    val imagePainter: Painter = painterResource(id = R.drawable.check)
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 20.dp),
        text = stringResource(id = R.string.randomizedoptions),
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp

    )

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        for ((number,choice) in choices.withIndex()) {

            val same = number == state.value
            Row(
                modifier = Modifier
                    .width(344.dp)
                    .height(60.dp)
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(5.dp))
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(if (same) Color(0xFF0D7BFF) else Color.Transparent)
                    .clickable {
                        if (state.value == number) {
                            state.value = -1
                        } else
                            state.value = number
                    },
                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(modifier= Modifier
                    .padding(vertical = 15.dp, horizontal = 10.dp),
                    text = choice,
                    color = if (same) Color.White else Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(270.dp))
                Image(painter = imagePainter, contentDescription = "check",
                    modifier = Modifier
                        .size(20.dp)

                )


            }
            Spacer(modifier = Modifier.height(12.dp))


        }
    }
}