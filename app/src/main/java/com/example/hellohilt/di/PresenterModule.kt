package com.example.hellohilt.di

import com.example.hellohilt.presentation.UserInputMvpView
import com.example.hellohilt.presentation.UserInputPresenter
import com.example.hellohilt.presentation.UserInputPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
interface PresenterModule {
    @Binds
    fun userInputPresenter(presenter: UserInputPresenterImpl): UserInputPresenter<UserInputMvpView>
}