package com.example.sdkegemen.ui.theme.presentation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sdkegemen.R
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun DropdownDemo() {
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy)
    )
    val options =
        listOf("First Option", "Second Option", "Third Option", "Fourth Option", "Fifth Option")
    var selected by remember { mutableStateOf("Click here") }
    var searchText by remember { mutableStateOf("") }

    val filteredColors = options.filter { it.contains(searchText, ignoreCase = true) }

    val toggleModalBottomSheetState = {
        coroutineScope.launch {
            if (!modalBottomSheetState.isAnimationRunning) {
                if (modalBottomSheetState.isVisible) {
                    modalBottomSheetState.hide()
                } else {
                    modalBottomSheetState.show()
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
            .clickable {
                toggleModalBottomSheetState()
            }
    ) {
        Text(
            text = " $selected ",
            modifier = Modifier
                .padding(16.dp)
        )
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = {
                Text(
                    text = stringResource(id = R.string.dropdown),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    fontWeight = FontWeight.Bold
                )
                TextField(
                    value = searchText,
                    onValueChange = { newValue ->
                        searchText = newValue
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    placeholder = {
                        Text(text = "Search...")
                    }
                )
                if (filteredColors.isEmpty()) {
                    Text(
                        text = "No matching items found",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    )
                } else {
                    filteredColors.forEach { color ->
                        Text(
                            text = color,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selected = color
                                    toggleModalBottomSheetState()
                                }
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 12.dp,
                                ),
                        )
                    }
                }
            },
            content={}
        )
    }
}