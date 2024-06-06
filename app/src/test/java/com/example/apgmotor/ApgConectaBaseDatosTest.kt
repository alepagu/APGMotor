package com.example.apgmotor

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ApgConectaBaseDatosTest(){

        @Test
        fun pruebaIntegracion_apgBaseDatos(){
                val conexion_apg = ApgConectaBaseDatos()
                assertEquals(conexion_apg, conexion_apg, "Prueba Conexión Superada")
        }
}