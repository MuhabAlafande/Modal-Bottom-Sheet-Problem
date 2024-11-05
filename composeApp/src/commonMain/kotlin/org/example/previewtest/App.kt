package org.example.previewtest

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var isBottomSheetExpanded by remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopAppBar(title = { Text(text = "Modal Bottom Sheet Test") }) },
            floatingActionButton = {
                FloatingActionButton(onClick = { isBottomSheetExpanded = true }) {
                    Icon(Icons.Default.Add, contentDescription = null)
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) {
            var textFieldValue by remember { mutableStateOf("") }
            val interactionSource = MutableInteractionSource()
            val isFocused by interactionSource.collectIsFocusedAsState()

            Box(modifier = Modifier.fillMaxSize().background(color = Color.Blue))

            if (isBottomSheetExpanded) ModalBottomSheet(
                sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = isFocused),
                onDismissRequest = { isBottomSheetExpanded = !isBottomSheetExpanded },
                dragHandle = null,
                modifier = Modifier.fillMaxSize().statusBarsPadding()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TextField(
                        value = textFieldValue,
                        onValueChange = { textFieldValue += it },
                        interactionSource = interactionSource
                    )

                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Button 1")
                    }
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Button 2")
                    }
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Button 3")
                    }
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Button 4")
                    }
                }
            }
        }
    }
}