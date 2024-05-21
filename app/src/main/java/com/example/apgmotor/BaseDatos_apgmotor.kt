package com.example.apgmotor

import android.os.AsyncTask
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Esta clase recoge una interfaz, que genera avisos de conexión y fallos.
 * Además, tiene una función que recoge todos los datos de la conexión y
 * una subclase privada que realiza la conexión con control de excepciones.
 */
class BaseDatos_apgmotor(private val listener: OnResultadoConexionListener) {

    interface OnResultadoConexionListener {
        fun apgRealizaConexion()
        fun apgSinConexion(apg_error: String)
    }

    fun apgRealizaConexion() {
        apgCrearConexion().execute()
    }

    /**
     * En la siguente clase interna, se crea una función que recoge los datos necesarios para
     * conectarse a la base de datos y luego poder ser llamada y utiliza desde la aplicación.
     */
    inner class apgCrearConexion : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            try {
                // Cargar el controlador JDBC de MariaDB
                Class.forName("org.mariadb.jdbc.Driver")
                // URL de conexión a la base de datos, usuario de acceso y contraseña de acceso
                val apg_url = "jdbc:mariadb://alejandroapp.duckdns.org:3309/apg_motor"
                val apg_usuario = "alejandro"
                val apg_contrasenna = "545G8apeLOhm5Ddskq6Cd0irTzdyaO"

                // Realizar la conexión
                val apg_conexion: Connection = DriverManager.getConnection(apg_url, apg_usuario, apg_contrasenna)
                // Comprobar que se conecta con éxito
                listener.apgRealizaConexion()
                // Cerrar la conexión
                apg_conexion.close()

            } catch (e: ClassNotFoundException) { //Controlar excepción si la clase no funciona
                e.printStackTrace()
                listener.apgSinConexion("Error de clase: " + e.message)
            } catch (e: SQLException) { //Controlar los fallos producidos con la base de datos
                e.printStackTrace()
                listener.apgSinConexion("Error de SQL: " + e.message)
            }
            return null
        }
    }
}