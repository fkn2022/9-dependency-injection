package com.example.hellohilt.di

import javax.inject.Inject

class FooTextProvider @Inject constructor() : TextProvider {
    override fun text(): String = "foo"
}