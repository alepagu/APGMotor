package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ingresargastos_apgmotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingresargastos_apgmotor)

        //Añadir lista de compornentes al Desplegable de esta pantalla
        val apg_desplegableCategoria: Spinner = findViewById(R.id.desplegableCategorias)

        val apg_opcionesCategoria = arrayOf("Seleccione un gasto","Repostar Combustible", "Mantenimiento", "ITV", "Arreglo de Avería")

        // Adaptador para que el desplegable recoja los valores
        val apg_adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, apg_opcionesCategoria)
        apg_adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        apg_desplegableCategoria.adapter = apg_adaptador

        // Funcionalidad del desplegable segúl la selección
        apg_desplegableCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //Creamos la asignación del campo que deben leer los valores cada variable
                val opcionSeleccionada = apg_opcionesCategoria[position]
                val importe_apg = R.id.importe
                val kilometros_apg = R.id.txtkm
                val descripcion_apg = R.id.descripcion

                val datos_apg = importe_apg + kilometros_apg + descripcion_apg

                //Comprobamos que tengamos valores que se puedan leer y si se ha seleccionado categoría
                if (datos_apg!= null && opcionSeleccionada!= apg_opcionesCategoria[0]){
                    //Creamos la Select para comprobar datos
                    val consulta_apg = "INSERT INTO gastos (cantidad_gasto, kilometros, descripcion, cod_categorias) VALUES ($importe_apg, $kilometros_apg, $descripcion_apg, $opcionSeleccionada)"
                    val apiPersonal_url = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="

                    //Intercambiar espaciados por el formato de mi api
                    consulta_apg.replace(" ", "%20", false)

                    var lanzaConsulta_apg = (apiPersonal_url + consulta_apg)
                    lanzaConsulta_apg

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Si no se ejecuta la consulta no mostrar ni realizar nada
            }
        }

        //Añadir funcionalidad al botón de Añadir Gastos
        val btngastos: Button = findViewById(R.id.btn_agregar)
        btngastos.setOnClickListener{
            Toast.makeText(this, "Se ha guardado el fallo con éxito", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}