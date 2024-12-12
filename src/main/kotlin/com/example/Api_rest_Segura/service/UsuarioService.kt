package com.example.Api_rest_Segura.service


import com.example.Api_rest_Segura.error.APIExceptionHandler
import com.example.Api_rest_Segura.model.Usuario
import com.example.Api_rest_Segura.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService : UserDetailsService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository


    /*
    TODO
     */
    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario: Usuario = usuarioRepository
            .findByUsername(username!!)
            .orElseThrow()

        return User.builder()
            .username(usuario.email)
            .password(usuario.password)
            .authorities(usuario.rol)
            .build()
    }

    fun registerUsuario(usuario: Usuario?): Usuario? {
        // Verificar si el usuario ya existe
        if (usuario != null) {
            if (usuarioRepository.findByUsername(usuario.nombre).isPresent) {
                throw IllegalArgumentException ("El usuario con este nombre ya existe")
            }
        }


        val passwordEncoder = org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
        usuario?.password = passwordEncoder.encode(usuario?.password )


        val nuevoUsuario = usuarioRepository.save(usuario!!)


        return nuevoUsuario
    }
}