package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R
import org.w3c.dom.Text

@Composable
fun LongText(modifier: Modifier) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    val isFocused = rememberUpdatedState(newValue = false)

    Column {
        Text(modifier=Modifier.fillMaxWidth().padding(vertical = 20.dp, horizontal = 20.dp),
            text = stringResource(id = R.string.longtext),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic)
        OutlinedTextField(
            value = text,
            textStyle = TextStyle(fontSize = 18.sp),
            onValueChange = {
                text = it

            },
            singleLine = false,
            modifier = Modifier
                .padding(16.dp)
                .height(100.dp)
                .background(Color.Transparent)
                .padding(4.dp)
                .fillMaxWidth()

        )
    }
}