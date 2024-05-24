package com.example.apgmotor

import android.os.StrictMode
import android.util.Log
//import org.mariadb.jdbc.Connection
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class BaseDatos_apgmotor {
        //Constantes para la conexión de la base de datos
//        private val urlBdAPG = "jdbc:mariadb://alejandroapp.duckdns.org:3310/apg_motor"

//        private val urlBdAPG = "jdbc:mysql://alejandroapp.duckdns.org:3310/apg_motor"
//        private val usuarioAPG = "alejandro"
//        private val contrasennaAPG = "545G8apeLOhm5Ddskq6Cd0irTzdyaO"

        private val urlBdAPG = "jdbc:mysql://:3306/apg_motor"
        private val usuarioAPG = "alejandro"
        private val contrasennaAPG = "padillaTFGguale24"

        fun ConexionDB_apgmotor(): Connection? {

                //Agregación de restricciones
                val apg_rest = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(apg_rest)

                //Comenzamos con la conexion
                var conexion_apg: Connection? = null //Sin conexión o conexión nula
                val cadena_conexion_apg: String // Formato de conexión en cadena

                //Manejamos posibles opciones de errores en la conexión
                try{
                        //Class.forName("org.mariadb.jdbc.Driver")
                        Class.forName("com.mysql.cj.jdbc.Driver")
                        cadena_conexion_apg = urlBdAPG + "\n" + usuarioAPG + "\n" + contrasennaAPG
                        conexion_apg = DriverManager.getConnection(cadena_conexion_apg)

                } catch (ex: SQLException){
                        //Fallo de SQL
                        ex.message?.let { Log.e("Error", it) }

                }catch (exc: ClassNotFoundException){
                        //Fallo de Funcionamiento de la clase
                        exc.message?.let { Log.e("Error", it) }

                }catch (e: Exception){
                        //Fallo de cualquier otra excepcion
                        e.message?.let { Log.e("Error", it) }
                }

                return  conexion_apg
        }
}


// https://mariadb.com/kb/es/acerca-de-mariadb-connectorj/