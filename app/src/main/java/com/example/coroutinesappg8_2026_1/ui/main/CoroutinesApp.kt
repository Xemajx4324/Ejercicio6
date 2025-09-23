package com.example.coroutinesappg8_2026_1.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coroutinesappg8_2026_1.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {
    var changeColor by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { changeColor = !changeColor },
            colors = ButtonDefaults.buttonColors(if (changeColor) Color.Blue else Color.Red)
        ) {
            Text(text = "Cambio de Color")
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Se muestran ambos contadores
        Text(text = "Contador 1: ${mainViewModel.countTime} [s]")
        Text(text = "Contador 2: ${mainViewModel.countTime2} [s]")
        Text(text = mainViewModel.resultState)

        Spacer(modifier = Modifier.height(30.dp))

        // Fila para los botones de acción
        Row {
            Button(onClick = { mainViewModel.fetchData() }) {
                Text(text = "Realizar Consulta")
            }

            Spacer(modifier = Modifier.width(20.dp))

            // Se añade el botón para cancelar
            Button(onClick = { mainViewModel.cancelCounting() }) {
                Text(text = "Cancelar")
            }
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun CoroutinesAppPreview(){
    CoroutinesAppG820261Theme(darkTheme = false ) {
        CoroutinesApp()
    }
}
*/