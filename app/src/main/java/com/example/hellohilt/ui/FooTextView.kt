package com.example.hellohilt.ui

import android.content.Context
import android.util.AttributeSet
import com.example.hellohilt.di.FooText
import com.example.hellohilt.di.TextProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FooTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyle) {
    @Inject
    @FooText
    lateinit var textProvider: TextProvider

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        text = textProvider.text()
    }
}