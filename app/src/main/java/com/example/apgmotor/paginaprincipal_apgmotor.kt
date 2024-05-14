package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class paginaprincipal_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_paginaprincipal_apgmotor)

        //Añadir funcionalidad al botón de Iniciar Sesión
        val btnNuevoVehiculo: Button = findViewById(R.id.btn_av)
        btnNuevoVehiculo.setOnClickListener{
            val intent: Intent = Intent(this, nuevovehiculo_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}