package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun ScriptFormatterScreen() {
    var text by remember { mutableStateOf("") }
    var formattedText by remember { mutableStateOf("") }
    val clipboardManager = LocalClipboardManager.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Script") },
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
        Button(
            onClick = {
                val words = text.split("\\s+".toRegex())
                val result = mutableListOf<String>()
                var currentLine = mutableListOf<String>()
                
                for (word in words) {
                    currentLine.add(word)
                    if (currentLine.size >= 5) {
                        result.add(currentLine.joinToString(" "))
                        currentLine.clear()
                    }
                }
                if (currentLine.isNotEmpty()) {
                    result.add(currentLine.joinToString(" "))
                }
                formattedText = result.joinToString("\n")
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Format Script")
        }
        OutlinedTextField(
            value = formattedText,
            onValueChange = {},
            label = { Text("Formatted Script") },
            modifier = Modifier.fillMaxWidth().weight(1f),
            readOnly = true
        )
        Button(
            onClick = { clipboardManager.setText(AnnotatedString(formattedText)) },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Salin Semua")
        }
    }
}
