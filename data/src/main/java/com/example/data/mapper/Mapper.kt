package com.example.data.mapper

interface Mapper<in FROM, out TO> {
    fun map(from: FROM): TO
}