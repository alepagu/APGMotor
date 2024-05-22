package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ingresargastos_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingresargastos_apgmotor)

        //Añadir lista de compornentes al Desplegable de esta pantalla
        val apg_desplegableCategoria: Spinner = findViewById(R.id.desplegableCategorias)

        val apg_opcionesCategoria = arrayOf("Repostar Combustible", "Mantenimiento", "ITV", "Arreglo de Avería")

        // Adaptador para que el desplegable recoja los valores
        val apg_adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, apg_opcionesCategoria)
        apg_adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        apg_desplegableCategoria.adapter = apg_adaptador

        // Funcionalidad del desplegable segúl la selección
        apg_desplegableCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val opcionSeleccionada = apg_opcionesCategoria[position]
                // Coger el valor de la selección realizada por el usuario.

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Acción cuando no se ha seleccionado nada
            }
        }

        //Añadir funcionalidad al botón de Añadir Gastos
        val btngastos: Button = findViewById(R.id.btn_agregar)
        btngastos.setOnClickListener{
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}