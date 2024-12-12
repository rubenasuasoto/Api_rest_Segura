package com.example.Api_rest_Segura.model
import jakarta.persistence.*


@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUsuario: Long? = null,

    @Column(nullable = false)
    val nombre: String? = null,

    @Column(nullable = false, unique = true)
    val email: String? = null,

    @Column(nullable = false)
    val password: String? = null,


    val rol: String? = null // e.g., "ROLE_CLIENTE,ROLE_MECANICO
)

