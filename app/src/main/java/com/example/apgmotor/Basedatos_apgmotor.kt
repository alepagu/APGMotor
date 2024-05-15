package com.example.apgmotor

import org.mariadb.jdbc.Driver
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object Basedatos_apgmotor {

    fun conexion(): Connection? {
        print("Ejecutando el principio de la conexión")
        var connection: Connection? = null
        try {
            // Cargar el controlador JDBC
            //Class.forName("org.mariadb.jdbc.Driver")
            DriverManager.registerDriver(Driver())

            // Establecer la conexión
            val baseDeDatos = "jdbc:mariadb://alejandroapp.duckdns.org:3309/apg_motor"
            val usuario = "alejandro"
            val contrasenna = "545G8apeLOhm5Ddskq6Cd0irTzdyaO"

            connection = DriverManager.getConnection(baseDeDatos, usuario, contrasenna)
            println("FUNCIONA")

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return connection
    }

    fun main() {
        val connection = conexion()

        if (connection != null) {
            try {
                val statement: Statement = connection.createStatement()
                val resultSet: ResultSet = statement.executeQuery("SELECT * FROM modelos")

                while (resultSet.next()) {
                    val id = resultSet.getInt("id")
                    val id_marca = resultSet.getInt("id_marca")
                    val modelo = resultSet.getString("modelo")
                    println("ID: $id, ID_MARCA: $id_marca, Nombre: $modelo")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        } else {
            println("No se pudo establecer la conexión a la base de datos.")
        }
    }
}