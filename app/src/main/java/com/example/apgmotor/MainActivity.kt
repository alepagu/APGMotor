package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
        setTheme(R.style.AppTheme)
        //Preparación de la aplicación
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        setContentView(R.layout.login_apgmotor)

        //Añadir funcionalidad al botón de Regístrate
        val btnRegistrarse: Button = findViewById(R.id.bt_registrate)
        btnRegistrarse.setOnClickListener{
            val intent: Intent = Intent(this, Registro:: class.java)
            startActivity(intent)
        }

        //Añadir funcionalidad al botón de Iniciar Sesión
        val btnlogin: Button = findViewById(R.id.bt_login)
        btnlogin.setOnClickListener{
            val intent: Intent = Intent(this, paginaprincipal_apgmotor:: class.java)
            startActivity(intent)
        }

        /**
         * El siguiente código realiza la función de mostrar un desplegable
         */
        //Añadir elementos al desplegable Temas Disponibles de la ventana
//        val items = listOf("Por Defecto", "Tema Claro", "Tema Oscuro")
//        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)
//        //Adaptamos la lista a los valores que requiere el desplegable
//        val adapter = ArrayAdapter(this, R.layout.activity_main, items)
//        autoComplete.setAdapter(adapter)
//        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
//            AdapterView, view, i, l ->
//
//            val itemSelected = AdapterView.getItemAtPosition(i)
//            //Mostramos el dato escogido
//            Toast.makeText(this, "item: $itemSelected", Toast.LENGTH_SHORT).show()
//        }
    }
}