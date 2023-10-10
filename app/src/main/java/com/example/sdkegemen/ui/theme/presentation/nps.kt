package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R
import org.w3c.dom.Text



@Composable
fun ClickableNPS(modifier: Modifier){

    val selectedNumber = remember { mutableStateOf(-1) }
        Text(
        stringResource(id = R.string.nps),modifier = Modifier.padding(vertical = 25.dp, horizontal =20.dp),
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp)


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        for (number in 0..10) {
            val isClicked = number == selectedNumber.value
            val ordered = number < selectedNumber.value || number == selectedNumber.value
            Box(
                modifier = Modifier
                    .padding(3.dp)
                    .width(27.dp)
                    .height(60.dp)
                    //.border(1.dp,Color.LightGray, shape = RoundedCornerShape(5.dp)) did not work
                    .then(
                        if (ordered) Modifier.border(1.dp,Color(0xFF0D7BFF), shape = RoundedCornerShape(5.dp)) else Modifier)
                    .background(if (isClicked) Color(0xFF0D7BFF) else Color.Transparent,
                        shape = RoundedCornerShape(5.dp))
                    .border(1.dp,Color.LightGray, shape = RoundedCornerShape(5.dp))
                    .clickable {
                        if (selectedNumber.value==number  ){
                            selectedNumber.value=-1

                        }
                        else
                            selectedNumber.value = number
                    }
            ) {
                Text(
                    text = number.toString(),
                    modifier = Modifier.align(Alignment.Center),
                    )
            }
        }
    }
}














