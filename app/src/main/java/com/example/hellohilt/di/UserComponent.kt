package com.example.hellohilt.di

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

interface User

interface Bar

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class LoggedInUserScope

@LoggedInUserScope
@DefineComponent(parent = SingletonComponent::class)
interface UserComponent {
}

@DefineComponent.Builder
interface UserComponentBuilder {
    fun withUser(@BindsInstance user: User): UserComponentBuilder
    fun build(): UserComponent
}

@LoggedInUserScope
class UserDataRepository @Inject constructor()

@EntryPoint
@InstallIn(UserComponent::class)
interface UserComponentEntryPoint {
    fun userDataRepository(): UserDataRepository
}

@Singleton
class UserManager @Inject constructor(
    private val builder: UserComponentBuilder
) {
    var userComponent: UserComponent? = null
        private set

    fun login(user: User) {
        userComponent = builder.withUser(user).build()
        val entryPoint = EntryPoints.get(userComponent, UserComponentEntryPoint::class.java)
        val userDataRepository = entryPoint.userDataRepository()
    }

    fun logout() {
        userComponent = null
    }
}