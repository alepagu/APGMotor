package com.example.apgmotor

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

class Login_apgmotor : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        //Preparación de la aplicación
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno
        setContentView(R.layout.login_apgmotor)


        // Busca el botón de iniciar sesión por su id
        val btniniciar: Button = findViewById(R.id.bt_login)

        // Se crean las acciones para el acceso
        btniniciar.setOnClickListener {
            //Comprobar los valores en la base de datos
            val correo_apg = R.id.introducecorreo
            val contrasenna_apg = R.id.introducecontrasenna

            //Creamos la Select para comprobar datos
            val consulta_apg = "SELECT * FROM usuarios WHERE correo = $correo_apg AND contrasenna = $contrasenna_apg"
            val apiPersonal_url = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="
            //Intercambiar espaciados por el formato de mi api
            //Preparación de la url para la api
            var cambio = consulta_apg.replace(" ", "%20", false)

            //lanzamos la consulta con la api
            //val lanzaConsulta_apg = (apiPersonal_url + cambio)
            lanzarConsulta(correo_apg, contrasenna_apg)

            //Comparar datos diferentes de valor nulo
            if (correo_apg != null && contrasenna_apg != null){
                //lanzaConsulta_apg
                val intent: Intent = Intent(this, paginaprincipal_apgmotor::class.java)
                startActivity(intent)

                Toast.makeText(this, "Entrando a la aplicación con el usuario introducido", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Algún dato introducido es incorrecto", Toast.LENGTH_SHORT).show()

            }

        }

            //Añadir funcionalidad al botón de Regístrate
            val btnRegistrarse: Button = findViewById(R.id.bt_registrate)
            btnRegistrarse.setOnClickListener {
                val intent: Intent = Intent(this, Registro_apgmotor::class.java)
                startActivity(intent)
            }

        }

    fun lanzarConsulta(correo: Int, contrasenna: Int): String {
        val api_apgmotor = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="
        val consulta_apg = "SELECT * FROM usuarios WHERE correo = $correo AND contrasenna = $contrasenna"
        val lanzaConsulta_apg = (api_apgmotor + consulta_apg.replace(" ", "%20"))
        return lanzaConsulta_apg
    }
}
