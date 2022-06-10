package com.example.hellohilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewComponent

@Module
@InstallIn(ViewComponent::class)
interface TextProviderModule {
    @FooText
    @Binds
    fun fooTextProvider(textProvider: FooTextProvider): TextProvider

    @BarText
    @Binds
    fun barTextProvider(textProvider: BarTextProvider): TextProvider
}