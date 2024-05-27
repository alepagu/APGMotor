package com.example.apgmotor

import org.junit.jupiter.api.Test

class PruebasIntegración_apgmotor {

    /**
     * En esta función compruebo que los datos que tengo en el logín sean iguales para poder entrar.
     * Se ha realizado con valores estáticos para poder comprobar el funcionamiento
     */
    @Test
    fun InicioUsusario() {
        var acceso = 1
        var usuario_apg = "padilla.guale24@cordoba.salesianos.edu"
        var contrasenna_apg = "padilla24"

        if (usuario_apg == "padilla.guale22@cordoba.salesianos.edu" && contrasenna_apg == "padilla24") {
            println("La prueba se ha realizado con éxito")
            acceso = 0

        } else {

            println("Algo no ha funcionado")
            acceso = 1
        }

    }

}