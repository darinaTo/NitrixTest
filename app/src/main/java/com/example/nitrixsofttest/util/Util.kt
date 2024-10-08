package com.example.nitrixsofttest.util

fun generateVideoThumbnailUrl(baseUrl: String, fileName: String): String {
    val fileWithoutExtension = baseUrl.substringBefore("/sample")
    return "$fileWithoutExtension/sample/$fileName"
}
