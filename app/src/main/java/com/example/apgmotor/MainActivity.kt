package com.example.apgmotor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apgmotor.ui.theme.APGMotorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Pantalla con logo de aplicación
        Thread.sleep(2000)
        //setTheme(R.layout.activity_pantalla_logo_apgmotor)
        //Preparación de la aplicación
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_apgmotor)
        //setContentView(R.layout.registro_apgmotor)
    }
}