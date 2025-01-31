package com.example.Api_rest_Segura.controller



import com.example.Api_rest_Segura.error.exception.BadRequestException
import com.example.Api_rest_Segura.model.Usuario
import com.example.Api_rest_Segura.security.SecurityConfig
import com.example.Api_rest_Segura.service.TokenService
import com.example.Api_rest_Segura.service.UsuarioService
import com.example.Api_rest_Segura.util.CipherUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    @Autowired
    private lateinit var usuarioService: UsuarioService
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var  tokenService: TokenService
    @Autowired
    private lateinit var  securityConfig: SecurityConfig
    @Autowired
    private lateinit var  cipherUtils: CipherUtils

    /*
    MÉTODO PARA INSERTAR UN USUARIO
     */
    @PostMapping("/register")
    fun register(
        @RequestBody newUsuario: Usuario
    ) : ResponseEntity<Usuario?>? {

        try {
            // Comprobación mínima
            if (newUsuario.username.isNullOrBlank() && newUsuario.password.isNullOrBlank()) {
                throw BadRequestException("El username y la contraseña son obligatorios")
            }
            // Generar un token JWT que se utilizará como clave de cifrado
            val token = securityConfig.jwtEncoder()


            // Cifrar la contraseña con el token como clave
            val cifrada = cipherUtils.encrypt(newUsuario.password,token.toString())
            newUsuario.password = cifrada

            // Llamar al servicio para insertar el usuario
            val usuarioInsertado = usuarioService.registerUsuario(newUsuario)

            return ResponseEntity(usuarioInsertado, HttpStatus.CREATED)
        } catch (e: Exception) {
            println("Error en el registro de usuario: ${e.message}")
            return ResponseEntity(null, HttpStatus.BAD_REQUEST)
        }
    }
    /*
    Metodo (EndPoint) para hacer un login
     */
    @PostMapping("/login")
    fun login(@RequestBody usuario: Usuario) : ResponseEntity<Any>? {

        val authentication: Authentication
        try {
            authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(usuario.username,usuario.password))
        } catch (e: AuthenticationException) {
            return ResponseEntity(mapOf("mensaje" to "Credenciales incorrectas dude"), HttpStatus.UNAUTHORIZED)
        }


        // SI PASAMOS LA AUTENTICACIÓN, SIGNIFICA QUE ESTAMOS BIEN AUTENTICADOS
        // PASAMOS A GENERAR EL TOKEN
        var token = ""
        token = tokenService.generarToken(authentication)


        return ResponseEntity(mapOf("token" to token), HttpStatus.CREATED)
    }


    /**
     * Endpoint para obtener un usuario por ID
     */
    @GetMapping("/{id}")
    fun getUsuarioById(@PathVariable id: Long): ResponseEntity<Usuario> {
        val usuario = usuarioService.getUsuarioById(id)
        if (usuario != null) {
            if (usuario.roles != "Admin") {
                throw IllegalArgumentException("No puedes acceder a otro usuario")
            }
        }
        return ResponseEntity.ok(usuario)
    }
    /**
     * Endpoint para obtener todos los usuarios
     */
    @GetMapping
    fun getUsuarios(): ResponseEntity<List<Usuario>> {
        val usuario = usuarioService.getAllUsuarios()
        return ResponseEntity.ok(usuario)
    }

    /**
     * Endpoint para actualizar un usuario por ID
     */
    @PutMapping("/{id}")
    fun updateUsuario(
        @PathVariable id: Long,
        @RequestBody usuarioActualizado: Usuario
    ): ResponseEntity<Usuario> {
        val usuario = usuarioService.updateUsuario(id, usuarioActualizado)
        return ResponseEntity.ok(usuario)
    }

    /**
     * Endpoint para eliminar un usuario por ID
     */
    @DeleteMapping("/{id}")
    fun deleteUsuario(@PathVariable id: Long): ResponseEntity<Void> {
        usuarioService.deleteUsuario(id)
        return ResponseEntity.noContent().build()
    }
}
