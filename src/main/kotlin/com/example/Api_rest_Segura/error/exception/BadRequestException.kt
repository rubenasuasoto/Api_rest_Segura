package com.example.Api_rest_Segura.error.exception

class BadRequestException(message: String) : RuntimeException("Bad Request Exception (400). $message") {
}