package com.moviles.examenmoviles.data

data class CoworkingSpace(
    val id: Int,
    val name: String,
    val location: String,
    val pricePerHour: Double,
    val capacity: Int,
    val isAvailable: Boolean
)