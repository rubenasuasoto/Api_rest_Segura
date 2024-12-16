package com.example.Api_rest_Segura.model

import jakarta.persistence.*

@Entity
@Table(name = "talleres")
data class Taller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idTaller: Long? = null,

    @Column(nullable = false)
    var nombreTaller: String? = null,

    @Column(nullable = false)
    var direccion: String? = null,

    @Column(nullable = false, length = 9)
    var telefono: String? = null,


)