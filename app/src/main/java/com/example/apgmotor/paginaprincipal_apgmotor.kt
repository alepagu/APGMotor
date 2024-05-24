package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class paginaprincipal_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        setContentView(R.layout.activity_paginaprincipal_apgmotor)

        //Añadir funcionalidad al clicar las imágenes
        val imagenGolf: ImageButton = findViewById(R.id.golfito)
        imagenGolf.setOnClickListener{
            val intent: Intent = Intent(this, ingresargastos_apgmotor:: class.java)
            startActivity(intent)
        }

        //Añadir funcionalidad al botón de Iniciar Sesión
        val btnNuevoVehiculo: Button = findViewById(R.id.btn_av)
        btnNuevoVehiculo.setOnClickListener{
            val intent: Intent = Intent(this, nuevovehiculo_apgmotor:: class.java)
            startActivity(intent)
        }

        //Añadir funcionalidad a los botones del pie de página
        //INICIO
        val btncasita: ImageButton = findViewById(R.id.btn_inicio)
        btncasita.setOnClickListener{
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }

        //CONFIGURACIÓN
        val btnconfig: ImageButton = findViewById(R.id.btn_config)
        btnconfig.setOnClickListener{
            val intent: Intent = Intent(this, Configuracion_apgmotor:: class.java)
            startActivity(intent)
        }

        //VER GASTOS
        val btnvergastos: ImageButton = findViewById(R.id.btn_vgastos)
        btnvergastos.setOnClickListener{
            val intent: Intent = Intent(this, vergastos_apgmotor:: class.java)
            startActivity(intent)
        }

        //VER TESTIGOS
        val btnvertestigos: ImageButton = findViewById(R.id.btn_vtestigos)
        btnvertestigos.setOnClickListener{
            val intent: Intent = Intent(this, Vertestigos_apgmotor:: class.java)
            startActivity(intent)
        }

    }
}