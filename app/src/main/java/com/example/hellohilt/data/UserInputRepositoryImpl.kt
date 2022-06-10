package com.example.hellohilt.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInputRepositoryImpl @Inject constructor() : UserInputRepository {
    private var input: String = ""

    override fun saveUserInput(input: String) {
        this.input = input
    }

    override fun getUserInput(): String = input
}