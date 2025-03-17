package com.example.androiddd

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class ClickableText(
    private val color: Int,
    private val onClick: () -> Unit
) : ClickableSpan() {

    override fun onClick(widget: View) {
        onClick()
    }

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
        ds.color = color
    }
}