package com.example.Api_rest_Segura.controller



import com.example.Api_rest_Segura.model.Usuario
import com.example.Api_rest_Segura.service.TokenService
import com.example.Api_rest_Segura.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    @Autowired
    private lateinit var usuarioService: UsuarioService
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var  tokenService: TokenService

    /*
    MÉTODO PARA INSERTAR UN USUARIO
     */
    @PostMapping("/register")
    fun register(
        @RequestBody newUsuario: Usuario
    ) : ResponseEntity<Usuario?>? {

        // Comprobación mínima
        // -> La obviamos por ahora

        // Llamar al UsuarioService para insertar un usuario


        // Devolver el usuario insertado
        return ResponseEntity(null, HttpStatus.CREATED) // Cambiar null por el usuario insertado

    }
    /*
    Metodo (EndPoint) para hacer un login
     */
    @PostMapping("/login")
    fun login(@RequestBody usuario: Usuario): ResponseEntity<Any>?{

        var authentication: Authentication
        try {

            authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(usuario.nombre, usuario.password))
        } catch (e:AuthenticationException){
            return ResponseEntity(mapOf("mensaje" to "Credenciales incorrectas dude"), HttpStatus.UNAUTHORIZED)
        }

        // SI PASAMOS LA AUTENTICACIÓN , SIGNIFICA QUE ESTAMOS BIEN AUTENTICADOS
        // PASAMOS A GENERAR TOKEN
        var token = ""
        token = tokenService.generarToken(authentication)

        return ResponseEntity(mapOf("token" to token), HttpStatus.CREATED)
    }
}