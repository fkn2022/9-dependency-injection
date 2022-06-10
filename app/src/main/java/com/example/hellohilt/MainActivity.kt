package com.example.hellohilt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.hellohilt.presentation.UserInputMvpView
import com.example.hellohilt.presentation.UserInputPresenter
import com.example.hellohilt.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UserInputMvpView {
    @Inject lateinit var logger: Logger
    @Inject lateinit var presenter: UserInputPresenter<UserInputMvpView>

    lateinit var input: EditText
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logger.d("!@#MainActivity", "onCreate()")
        logger.d("!@#MainActivity", "Working with presenter: $presenter")
        logger.d("!@#MainActivity", "Working with logger: $logger")
        input = findViewById(R.id.input)
        submitButton = findViewById(R.id.submit)
        submitButton.setOnClickListener {
            presenter.onInputSubmit(input.text.toString())
        }
        presenter.attachView(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.d("!@#MainActivity", "onDestroy()")
        presenter.detachView()
    }

    override fun showSavedText(text: String) {
        input.setText(text)
    }
}