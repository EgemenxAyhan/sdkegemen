package com.example.sdkegemen.ui.theme.presentation

import android.graphics.Paint
import android.util.Log.v
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import org.w3c.dom.Text


@Composable
fun ClickableBox(modifier: Modifier) {
    val selectedIndex = remember { mutableStateOf(-1) } // Just selected box

    val imagePainter: Painter = painterResource(id = R.drawable.sad)

    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {
        Text(
            text = stringResource(id = R.string.sentiment),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        for (i in 0 until 5) {
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
                    .clip(RoundedCornerShape(5.dp))
                    .background(if (i == selectedIndex.value) Color(0xFF0D7BFF) else Color.Transparent)
                    .clickable {
                        selectedIndex.value = i
                    }
            ) {
                Image(
                    painter = imagePainter,
                    contentDescription = "sad emoji",
                    modifier = Modifier.fillMaxSize(1f).padding(8.dp)
                )
            }

            if (i < 4) {
                Spacer(modifier = Modifier.width(11.dp))
            }
        }
    }
}



