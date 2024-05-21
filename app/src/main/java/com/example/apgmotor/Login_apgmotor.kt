package com.example.apgmotor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class Login_apgmotor : ComponentActivity(), BaseDatos_apgmotor.OnResultadoConexionListener {

    //Aseguro que se pueda realizar uso de la base de datos
    private lateinit var apg_ConexionDB: BaseDatos_apgmotor

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inicializar la conexión
        apg_ConexionDB = BaseDatos_apgmotor(this)
        // Realizar la conexión
        apg_ConexionDB.apgRealizaConexion()
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

    }

    /**
     * Si se realiza la conexión el método de la interfaz, realizará el lanzamiento
     * del mensaje implementado
     */
    override fun apgRealizaConexion() {
        TODO("Not yet implemented")
        // Manejar el caso de conexión exitosa
        Log.d("APG_BD", "Conexión exitosa")
    }

    /**
     * Si la conexión resulta fallida el metodo de la interfaz, lanzara el mensaje de error
     * y su respctivo fallo
     */
    override fun apgSinConexion(apg_error: String) {
        TODO("Not yet implemented")
        // Manejar el caso de error de conexión
        Log.e("APG_BD", "Error de conexión: $apg_error")
    }
}