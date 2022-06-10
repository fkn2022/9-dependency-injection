package com.example.hellohilt.presentation

interface UserInputPresenter<T> {
    fun attachView(view: T)
    fun detachView()
    fun onInputSubmit(input: String)
}