package com.example.apgmotor

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Creación de la clase que realizaría la conexión si fuera posible.
 * Este es un ejemplo para observar, que si se conectar las Bases de Datos
 * a los IDEs.
 */
class ApgConectaBaseDatos(){

    /**
     * Esta función, realiza uso de ficheros LOG internos para comprobar el funcionamiento
     * correcto de la clase.
     */
    fun getConnection(): Connection? {
        //USAMOS EL LOG
        Log.d("Informativo de conexión", "VAMOS A EMPEZAR EL PROCESO.")

        //Asignación de las credenciales correctas a las variables de la conexión
        val apg_url_conexion = "jdbc:mariadb://127.0.0.1:3304/apg_motor"
        val apg_usuario_basedatos = "root"
        val apg_contrasenna_basedatos = "root"

        //USAMOS EL LOG
        Log.d("Informativo de conexión", "Se han recogido todas las variables.")

        //MANEJO DE EXCEPCIONES que devuelve el estado de la conexión
        return try {

            //USAMOS EL LOG
            Log.d("Informativo de conexión", "Se han recogido todas las variables.")

            //Si no surgen fallos se conecta a la base de datos
            DriverManager.getConnection(apg_url_conexion, apg_usuario_basedatos, apg_contrasenna_basedatos)

        } catch (e: SQLException) {
            //USAMOS EL LOG
            Log.d("Error de conexión", "No se ha podido conectar, algo ha fallado.")
            //En el caso de haber fallos es controlada solamente la parte de SQL. Y se devuelve valor null.
            e.printStackTrace()
            null
        }
    }
}