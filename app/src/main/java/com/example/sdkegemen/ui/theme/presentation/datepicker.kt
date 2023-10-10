package com.example.sdkegemen.ui.theme.presentation

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R
import java.util.*

@Composable
fun datePicker(context: Context) {
    Text(
        modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp),
        text = stringResource(id = R.string.date),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic
    )

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("DD/MM/YY") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )
    Box(
        modifier = Modifier
            .padding(20.dp)
            .width(344.dp)
            .height(56.dp)
            .border(
                1.dp, Color.LightGray,
                RoundedCornerShape(5.dp)
            )
            .clickable { datePickerDialog.show() }

    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterStart).padding(horizontal = 10.dp), fontSize = 16.sp, text = "${date.value}"
        )
    }


}