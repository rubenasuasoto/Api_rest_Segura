package com.example.Api_rest_Segura.service


import com.example.Api_rest_Segura.error.APIExceptionHandler
import com.example.Api_rest_Segura.error.exception.ConflictException
import com.example.Api_rest_Segura.error.exception.NotFoundException
import com.example.Api_rest_Segura.model.Usuario
import com.example.Api_rest_Segura.repository.UsuarioRepository
import com.example.Api_rest_Segura.security.SecurityConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService : UserDetailsService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository
    @Autowired
    private lateinit var handler: APIExceptionHandler
    @Autowired
    private lateinit var securityConfig: SecurityConfig


    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario: Usuario = usuarioRepository
            .findByUsername(username!!)
            .orElseThrow()

        return User.builder()
            .username(usuario.username)
            .password(usuario.password)
            .authorities(usuario.roles)
            .build()
    }

    fun registerUsuario(usuario: Usuario?): Usuario? {
        // Verificar si el usuario ya existe
        if (usuario != null) {
            if (usuarioRepository.findByUsername(usuario.username).isPresent) {
                 throw ConflictException("El usuario ya existe")
            }
        }



        usuario?.password = securityConfig.passwordEncoder().encode(usuario?.password )


        val nuevoUsuario = usuarioRepository.save(usuario!!)


        return nuevoUsuario
    }
    /**
     * Obtener todos los usuarios.
     */
    fun getAllUsuarios(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    /**
     * Obtener un usuario por ID.
     */
    fun getUsuarioById(id: Long): Usuario {
        return usuarioRepository.findById(id)
            .orElseThrow { NotFoundException("Usuario no encontrado con ID $id") }
    }

    /**
     * Actualizar un usuario existente por ID.
     */
    fun updateUsuario(id: Long, usuarioActualizado: Usuario): Usuario {
        val usuario = usuarioRepository.findById(id)
            .orElseThrow { NotFoundException("Usuario no encontrado con ID $id") }

        // Actualizar campos
        usuario.username = usuarioActualizado.username
        usuario.password = securityConfig.passwordEncoder().encode(usuarioActualizado.password)
        usuario.roles = usuarioActualizado.roles

        // Guardar cambios
        return usuarioRepository.save(usuario)
    }

    /**
     * Eliminar un usuario por ID.
     */
    fun deleteUsuario(id: Long) {
        if (!usuarioRepository.existsById(id)) {
            throw NotFoundException("Usuario no encontrado con ID $id")
        }
        usuarioRepository.deleteById(id)
    }
}
