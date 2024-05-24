package com.example.apgmotor.BBDDApgMotor

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

abstract class BaseDeDatos_apgmotor {

    //Cuando se usa ? detrás de una sentencia de conexión se está haciendo una especie de TERNARIO lo que permite controlar
    //las excepciones de respuestas nulas por parte de la base de datos. En este Package de base de datos lo veremos mucho.
    abstract var conexion: Connection?

    //abre la conexión con la base de datos y devuelve null si falla
    fun establecerConexion() {
        val url_apg = "jdbc:mysql://alejandroapp.duckdns.org:3310/biyd3n4dtmb0jjzgvbbt"
        val usuario_apg = "alejandro"
        val contrasenna_apg = "545G8apeLOhm5Ddskq6Cd0irTzdyaO"
        return try {
            conexion = DriverManager.getConnection(url_apg, usuario_apg, contrasenna_apg)
            println("Funciona")
        } catch (e: SQLException) {
            e.printStackTrace()
            conexion = null
        }
    }

    //cierra conexión pero no devuelve nada si lo consigue.
    fun cerrarConexion() {
        try {
            conexion?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}