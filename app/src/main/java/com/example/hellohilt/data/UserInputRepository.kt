package com.example.hellohilt.data

interface UserInputRepository {
    fun saveUserInput(input: String)
    fun getUserInput(): String
}