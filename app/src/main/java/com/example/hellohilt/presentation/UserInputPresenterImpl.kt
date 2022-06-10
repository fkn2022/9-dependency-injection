package com.example.hellohilt.presentation

import com.example.hellohilt.data.UserInputRepository
import com.example.hellohilt.utils.Logger
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserInputPresenterImpl @Inject constructor(
    private val userInputRepository: UserInputRepository,
    private val logger: Logger
) : UserInputPresenter<UserInputMvpView> {
    private var view: UserInputMvpView? = null

    override fun attachView(view: UserInputMvpView) {
        this.view = view
        logger.d("!@#UserInputPresenter", "Working with logger: $logger")
        logger.d("!@#UserInputPresenter", "Getting input from repository $userInputRepository")
        view.showSavedText(userInputRepository.getUserInput())
    }

    override fun onInputSubmit(text: String) {
        userInputRepository.saveUserInput(text)
    }

    override fun detachView() {
        view = null
    }
}