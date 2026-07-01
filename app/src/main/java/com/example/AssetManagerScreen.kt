package com.example

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AssetManagerScreen() {
    val context = LocalContext.current
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Asset Manager", style = MaterialTheme.typography.headlineMedium)
        Text("Manage your audio and video assets here.", modifier = Modifier.padding(vertical = 16.dp))
        
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("capcut://"))
                try {
                    context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(context, "CapCut not installed", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buka CapCut")
        }
    }
}
