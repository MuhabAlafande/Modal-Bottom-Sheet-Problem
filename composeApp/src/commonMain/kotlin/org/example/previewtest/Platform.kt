package org.example.previewtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform