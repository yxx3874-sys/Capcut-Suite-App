package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.theme.MyApplicationTheme

enum class Feature { TRENDS, SCRIPTS, ASSETS }

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          MainScreen(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
  var currentFeature by remember { mutableStateOf(Feature.TRENDS) }
  
  Column(modifier = modifier.fillMaxSize()) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
      Button(onClick = { currentFeature = Feature.TRENDS }) { Text("Trends") }
      Button(onClick = { currentFeature = Feature.SCRIPTS }) { Text("Scripts") }
      Button(onClick = { currentFeature = Feature.ASSETS }) { Text("Assets") }
    }
    when (currentFeature) {
      Feature.TRENDS -> TrendDashboardScreen()
      Feature.SCRIPTS -> ScriptFormatterScreen()
      Feature.ASSETS -> AssetManagerScreen()
    }
  }
}
