package com.example.nitrixsofttest.domain.entities

data class Video(
    val title: String,
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String
)
