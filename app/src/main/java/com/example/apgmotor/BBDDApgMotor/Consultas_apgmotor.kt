package com.example.apgmotor.BBDDApgMotor

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Consultas_apgmotor (override var conexion: Connection?): BaseDeDatos_apgmotor(){
    /**
     * Establecer la conexión de la clase abstracta que esta heredando. BaseDeDatos_apgmotor
     */
    init {
        establecerConexion()
    }

    fun ObtenerMarcas(): List<String>{
        val query = "SELECT marca FROM marcas LIMIT 5"
        val marcas = mutableListOf<String>()
        var statement: PreparedStatement? = null
        var resultSet: ResultSet? = null

        try {
            if (conexion == null) {
                establecerConexion()
            }
            statement = conexion?.prepareStatement(query)
            resultSet = statement?.executeQuery()

            while (resultSet?.next() == true) {
                val marca = resultSet.getString("marca")
                marcas.add(marca)
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            resultSet?.close()
            statement?.close()
            cerrarConexion()
        }
        return marcas
    }

}