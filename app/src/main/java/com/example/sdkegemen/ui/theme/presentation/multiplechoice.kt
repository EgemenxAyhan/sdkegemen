package com.example.sdkegemen.ui.theme.presentation


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R

@Composable
fun MultipleChoice(modifier: Modifier) {
    val state = remember{ mutableStateListOf(false,false,false,false)}
    val choices = listOf("A", "B", "C", "D")
    val Image : Painter= painterResource(id = R.drawable.check)
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 20.dp),
        text = stringResource(id = R.string.multiplechoice),
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp

    )

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        for ((number,choice) in choices.withIndex()) {

            val same = state[number]
            Row(
                modifier = Modifier
                    .width(344.dp)
                    .height(60.dp)
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(5.dp))
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(if (same) Color(0xFF0D7BFF) else Color.Transparent)
                    .clickable {
                        if (state[number] == true) {
                            state[number] = false
                        } else
                            state[number] = true

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
                Image(painter = Image, contentDescription = "check",
                    modifier = Modifier
                        .size(20.dp)

                )


            }
            Spacer(modifier = Modifier.height(12.dp))


        }
    }
}



