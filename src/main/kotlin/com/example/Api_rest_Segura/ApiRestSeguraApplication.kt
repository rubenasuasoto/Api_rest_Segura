package com.example.Api_rest_Segura

import com.example.Api_rest_Segura.security.RSAKeysProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RSAKeysProperties::class)
class ApiRestSeguraApplication

fun main(args: Array<String>) {
	runApplication<ApiRestSeguraApplication>(*args)
}
