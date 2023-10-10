package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R

@Composable
fun NumericTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(value) }

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp, horizontal = 20.dp),
        text = stringResource(id =R.string.numeric),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic)

    OutlinedTextField(
        value = text,
        onValueChange = {
            val newText = it.filter { char -> char.isDigit() }
            text = newText
            onValueChange(newText)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        textStyle = TextStyle(fontSize = 16.sp),
        modifier = Modifier
            .padding(20.dp)
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(5.dp))
            .clip(shape = RoundedCornerShape(5.dp))
            .width(344.dp)
            .height(56.dp)
    )
}