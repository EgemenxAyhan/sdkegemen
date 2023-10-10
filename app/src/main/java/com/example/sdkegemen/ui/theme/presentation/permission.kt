package com.example.sdkegemen.ui.theme.presentation

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.text.CaseMap
import android.net.Uri
import android.util.Log
import android.widget.Button
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.sdkegemen.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.reflect.KProperty


@Composable
fun Content() {
    val cameraPermission = Manifest.permission.CAMERA
    val readStoragePermission = Manifest.permission.READ_EXTERNAL_STORAGE
    val context = LocalContext.current
    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
    val image: Painter = painterResource(id = R.drawable.cloudupload)

    var isReadStoragePermissionGranted by remember {
        mutableStateOf(
            checkPermissionFor(
                context,
                readStoragePermission
            )
        )
    }

    val storageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                Log.d("TAG", "Camera $isGranted")
                isReadStoragePermissionGranted = true
            }
        })

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            Log.d("TAG", "Selected file URI: $uri")
        })

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(color = Color.Transparent)
        .drawBehind {
            drawRoundRect(
                color = Color.Black,
                style = stroke,
                cornerRadius = CornerRadius(5.dp.toPx())
            )
        }
        .height(80.dp)
        .width(344.dp)
        .clickable {
            Log.d("TAG", "Clicked on the upload button")
            if (!isReadStoragePermissionGranted) {
                Log.d("TAG", "Requesting storage permission")
                // Request read storage permission if not granted
                storageLauncher.launch(readStoragePermission)
            }
            else {
                // Launch the file picker activity
                Log.d("TAG", "Launching file picker")
                filePickerLauncher.launch("*/*") // Change the MIME type as needed
            }
        }
    ) {

        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.TopStart),
            text = "Click to upload file",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = image, contentDescription = "check",
            modifier = Modifier
                .size(40.dp)
                .align(alignment = Alignment.Center)
        )
    }
}

private fun checkPermissionFor(context: Context, permission: String) =
    ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED














