package com.example.hellohilt.di

import javax.inject.Inject

class BarTextProvider @Inject constructor() : TextProvider {
    override fun text() = "bar"
}