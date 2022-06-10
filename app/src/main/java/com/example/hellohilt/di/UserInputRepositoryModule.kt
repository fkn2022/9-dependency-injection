package com.example.hellohilt.di

import com.example.hellohilt.data.UserInputRepository
import com.example.hellohilt.data.UserInputRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserInputRepositoryModule {
    @Binds
    fun userInputRepository(repository: UserInputRepositoryImpl): UserInputRepository
}