package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class nuevovehiculo_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevovehiculo_apgmotor)

        //Añadir funcionalidad al botón de Iniciar Sesión
        val btnannadir: Button = findViewById(R.id.btn_add)
        btnannadir.setOnClickListener{
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}