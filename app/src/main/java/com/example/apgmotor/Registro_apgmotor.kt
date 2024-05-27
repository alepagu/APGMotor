package com.example.apgmotor

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.JsonWriter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.type.DateTime
import org.json.JSONStringer
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

class Registro_apgmotor : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        setContentView(R.layout.registro_apgmotor)

        //Añadir funcionalidad al botón Registrarme
        val btnRegistrado: Button = findViewById(R.id.btnregistrar)
        btnRegistrado.setOnClickListener{
            //Creamos la consulta para la insercción de nuevos usuarios
            var consultaInsertar_apg = "INSERT INTO usuarios (nombre, correo, contrasenna, fechaAlta) VALUES (?,?,?,?)"

            val nombre_apg = R.id.textonombre
            val correo_apg = R.id.textocorreo
            val contrasenna_apg = R.id.textocontrasenna
            val fecha_apg = null

            //Comprobación de que ningun campo sea nulo
            if (nombre_apg!= null && correo_apg!=null && contrasenna_apg!=null){
                //Insertamos los registros obtenidos
                val apiPersonal_url = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="
                //Se intercambian los datos necesarios para que se enlacen con la url de la api web
                val cambio= consultaInsertar_apg.replace(" ", "%20", false)

                var lanzaConsulta_apg = (apiPersonal_url + cambio)
                lanzaConsulta_apg
                Toast.makeText(this, "El usuario ya se ha creado con éxito", Toast.LENGTH_SHORT).show()
            }
            else{

                Toast.makeText(this, "Los datos no se han podido insertar, pruebe más tarde", Toast.LENGTH_SHORT).show()
            }

            //Generamos la aparición de un mensaje por la interfaz que indique el motivo del desplazamiento
            Toast.makeText(this, "Los datos ingresados ya han sido validados, inicie sesión.", Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(this, Login_apgmotor:: class.java)
            startActivity(intent)
        }
    }
}