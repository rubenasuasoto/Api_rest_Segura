package com.example.Api_rest_Segura.model
import jakarta.persistence.*


@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idUsuario: Long? = null,

    @Column(nullable = false, unique = true)
    var username: String,

    @Column(nullable = false)
    var password: String,


    var roles: String? = null // e.g., "ROLE_CLIENTE,ROLE_MECANICO
)

