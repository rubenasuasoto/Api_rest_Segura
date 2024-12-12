package com.example.Api_rest_Segura.error.exception

class ConflictException(message: String) : RuntimeException("Conflict Exception (409). $message") {
}