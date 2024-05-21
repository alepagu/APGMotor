package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class planificarfecha_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_planificarfecha_apgmotor)

        //Funcionalidad del botón
        val btnguardarFecha: Button = findViewById(R.id.btn_guardarfecha)
        btnguardarFecha.setOnClickListener{
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
        //MVC, ciclo de la vida de la app
    }
}