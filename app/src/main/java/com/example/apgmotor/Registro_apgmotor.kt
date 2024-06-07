package com.example.apgmotor

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

/**
 * En esta clase, Se realiza una comprobación de datos y si estos no se encuentran en la base de datos,
 * se realiza una inserción de dichos datos como nuevo usuario.
 * La BASE DE DATOS, se ha implementado con una api web diseñada en python.
 */
class Registro_apgmotor : AppCompatActivity() {
    //SE REALIZA UNA IMPORTACIÖN DE LA API NECESARIO
    @RequiresApi(Build.VERSION_CODES.O)

    //PRECARAGA DE LA VENTANA Y SUS ACCIONES DE RECOGIDA DE DATOS
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Se ajusta a las dimensiones del telefóno

        //SE IMPLEMENTA LA INTERFAZ XML PARA ESTA VENTANA
        setContentView(R.layout.registro_apgmotor)

        //FUNCIONES DEL BOTÓN
        //Añadir funcionalidad al botón Registrarme
        val btnRegistrado: Button = findViewById(R.id.btnregistrar)
        btnRegistrado.setOnClickListener{

            /**
             * PREPARACIÓN DE LA CONSULTA SQL HACIA LA API, PARA OBTENER UNA RESPUESTA
             * O EN SU DEFECTO LA INSERCCIÓN DEL NUEVO USUARIO
             */

            //CONSULTA
            var consultaInsertar_apg = "INSERT INTO usuarios (nombre, correo, contrasenna, fechaAlta) VALUES (?,?,?,?)"
            //VARIABLES NECESARIAS PARA EL REGISTRO
            val nombre_apg = R.id.textonombre
            val correo_apg = R.id.textocorreo
            val contrasenna_apg = R.id.textocontrasenna
            val fecha_apg = null //LA FECHA SE IMPLEMENTARÁ LA DEL DISPOSITIVO EN LA FUTURA VERSIÓN

            //SE REALIZA EL ACCESO SI NINGÚN CAMPO ES NULO
            //SI FALLA EL ACCESO SE REVISARÁ PARA SOLUCIONARLO EN LA PRÓXIMA VERSIÓN
            if (nombre_apg!= null && correo_apg!=null && contrasenna_apg!=null){
                //PREPARACIÓN DE LA URL DE LA API PARA LA IMPORTACIÓN
                val apiPersonal_url = "https://api.alejandroapp.duckdns.org/query?user=alejandro&passwd=545G8apeLOhm5Ddskq6Cd0irTzdyaO&query="
                //Se intercambian los datos necesarios para que se enlacen con la url de la api web
                val cambio= consultaInsertar_apg.replace(" ", "%20", false)

                var lanzaConsulta_apg = (apiPersonal_url + cambio)
                //SE LANZA LA CONSULTA A LA API
                lanzaConsulta_apg
                //SE MUESTA UN MENSAJE DE FORMA INTERNA
                Toast.makeText(this, "El usuario ya se ha creado con éxito", Toast.LENGTH_SHORT).show()
            }
            else{
                //SE CREA UN MENSAJE DE AVISO INTERNO
                Toast.makeText(this, "Los datos no se han podido insertar, pruebe más tarde", Toast.LENGTH_SHORT).show()
            }

            //INDICAMOS EL DESPLAZAMIENTO HACIA LA VENTANA INICIO DE SESIÓN
            Toast.makeText(this, "Los datos ingresados ya han sido validados, inicie sesión.", Toast.LENGTH_SHORT).show()
//SE EFECTÚA EL INTERCAMBIO DE LAS VENTANA
            val intent: Intent = Intent(this, Login_apgmotor:: class.java)
            //SE PREPARA LA PANTALLA Y SE INICIA DE FORMA ÁGIL
            startActivity(intent)
        }
    }
}