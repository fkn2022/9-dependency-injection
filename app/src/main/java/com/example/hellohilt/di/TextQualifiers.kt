package com.example.hellohilt.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FooText

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BarText
