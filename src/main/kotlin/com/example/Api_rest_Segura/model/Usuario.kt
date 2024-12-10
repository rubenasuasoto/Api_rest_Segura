package com.example.Api_rest_Segura.model
import jakarta.persistence.*

// Tabla Usuarios
@Entity
@Table(name = "Usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUsuario: Long = 0,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val rol: RolUsuario
)

enum class RolUsuario {
    CLIENTE, MECANICO
}