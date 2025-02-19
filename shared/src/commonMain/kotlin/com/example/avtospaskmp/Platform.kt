package com.example.avtospaskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform