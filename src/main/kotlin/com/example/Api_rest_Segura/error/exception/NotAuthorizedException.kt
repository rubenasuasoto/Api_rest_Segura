package com.example.Api_rest_Segura.error.exception

class NotAuthorizedException(message: String) : RuntimeException("Not Authorized Exception (401). $message") {
}