package com.example.sdkegemen

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.sdkegemen.ui.theme.SdkegemenTheme
import com.example.sdkegemen.ui.theme.presentation.*
import java.nio.file.WatchEvent
import java.util.jar.Manifest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            androidx.compose.material.Surface(modifier = Modifier.fillMaxSize(1f)) {


                MyLazyColumn()
                DropdownDemo()


            }

        }
    }
}

@Composable
fun MyLazyColumn() {
    val context = LocalContext.current
    val itemCount = 50 // Öğe sayısı
    var text = "Click Here"
    LazyColumn {
        item {
            ClickableBox(
                modifier = Modifier
                    .fillMaxWidth()
            )

        }
        item {
            ClickableNPS(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        item {
            SingleChoice(modifier = Modifier.fillMaxWidth())
        }
        item {
            MultipleChoice(modifier = Modifier.fillMaxWidth())
        }
        item {
            ShortText(modifier = Modifier.fillMaxWidth())
        }
        item {
            LongText(modifier = Modifier.fillMaxWidth())
        }
        item {
            SliderExample(modifier = Modifier.fillMaxWidth())
        }
        item {
            NumericTextField(value = text, onValueChange = { newValue -> text = newValue })
        }
        item {
            Agreement(modifier = Modifier.fillMaxWidth())
        }
        item {
            RandomizedOptions(modifier = Modifier.fillMaxWidth())
        }
        item {
            Stars(modifier = Modifier.fillMaxWidth())
        }
        item {
            Title(title = stringResource(id = R.string.ranking))
            Ranking(letter = "A")
            Ranking(letter = "B")
            Ranking(letter = "C")
            Ranking(letter = "D")

        }
        item {
            datePicker(context)
        }
        item {
            Title(title = stringResource(id = R.string.file))
            Content()
        }
        item {
            Title(title = stringResource(id = R.string.dropdown))
            DropdownDemo ()
        }
    }
}









