package com.example.Api_rest_Segura.error.exception

class NotFoundException(message: String) : RuntimeException("Not Found Exception (404). $message") {
}