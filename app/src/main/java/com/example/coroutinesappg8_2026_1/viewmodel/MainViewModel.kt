package com.example.coroutinesappg8_2026_1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var resultState by mutableStateOf("")
        private set

    var countTime by mutableStateOf(0)
        private set

    // 1. Se añade el segundo contador
    var countTime2 by mutableStateOf(0)
        private set

    // 2. Se crea una variable para controlar el Job (la tarea)
    private var countingJob: Job? = null

    // 3. Se anidan las subrutinas en funciones suspend
    private suspend fun runFirstCounter() {
        for (i in 1..5) {
            delay(1000)
            countTime = i
        }
    }

    private suspend fun runSecondCounter() {
        for (i in 1..5) {
            delay(1000)
            countTime2 = i
        }
    }

    fun fetchData() {
        // Se cancela cualquier Job anterior antes de iniciar uno nuevo
        countingJob?.cancel()

        // 4. Se inicia una única corrutina y se asigna al Job
        countingJob = viewModelScope.launch {
            // Reiniciar estados
            countTime = 0
            countTime2 = 0
            resultState = "Iniciando contadores..."

            // 5. Se ejecutan los contadores en secuencia
            runFirstCounter()
            runSecondCounter()

            resultState = "Contadores terminados."
        }
    }

    // 6. Nueva función para cancelar el Job
    fun cancelCounting() {
        countingJob?.cancel()
        countTime = 0
        countTime2 = 0
        resultState = "Proceso cancelado por el usuario."
    }
}