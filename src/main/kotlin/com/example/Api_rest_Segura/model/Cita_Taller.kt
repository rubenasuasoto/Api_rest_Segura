package com.example.Api_rest_Segura.model
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "citas_taller")
data class Cita_Taller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCita: Long? = null,

    @Column(name = "id_usuario",nullable = false)
    val usuario: String? = null,

    @Column(name = "id_taller",nullable = false)
    val taller: String? = null,

    @Column(nullable = false)
    var fecha: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var servicio: String? = null,

    @Column(nullable = false)
    var estado: String? = null
) {
    constructor() : this(
        idCita = null,
        usuario = null,
        taller = null,
        fecha = LocalDateTime.now(),
        servicio = null,
        estado = null
    )
}


