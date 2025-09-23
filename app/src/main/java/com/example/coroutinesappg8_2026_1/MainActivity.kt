package com.example.coroutinesappg8_2026_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coroutinesappg8_2026_1.ui.main.CoroutinesApp
import com.example.coroutinesappg8_2026_1.ui.theme.CoroutinesAppG820261Theme
import com.example.coroutinesappg8_2026_1.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by viewModels ()

        enableEdgeToEdge()
        setContent {
            CoroutinesAppG820261Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoroutinesApp(mainViewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

