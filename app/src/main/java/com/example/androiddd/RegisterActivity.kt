package com.example.androiddd

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androiddd.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val terms = binding.termsTextView.text.toString()
        val ssTerms = SpannableString(terms)
        val privacyPolicy = ClickableText(color = ContextCompat.getColor(this, R.color.blue), onClick = {})
        val userAgreement = ClickableText(color = ContextCompat.getColor(this, R.color.blue), onClick = {})

        ssTerms.setSpan(privacyPolicy, 37, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ssTerms.setSpan(userAgreement, 118, 145, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.termsTextView.text = ssTerms

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}