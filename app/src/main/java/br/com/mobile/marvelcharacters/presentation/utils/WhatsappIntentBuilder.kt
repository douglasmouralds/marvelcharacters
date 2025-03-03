package br.com.mobile.marvelcharacters.presentation.utils

import android.content.Intent
import android.net.Uri
import java.net.URLEncoder

class WhatsappIntentBuilder {
    companion object {
        private const val DEFAULT_PHONE_NUMBER = "19999660305"
        private const val DEFAULT_MESSAGE =
            "Estou utilizando o App Marvel Characters e queria mais detalhes sobre..."
    }

    private var phoneNumber: String = DEFAULT_PHONE_NUMBER
    private var message: String = DEFAULT_MESSAGE

    fun setPhoneNumber(phoneNumber: String): WhatsappIntentBuilder {
        this.phoneNumber = phoneNumber
        return this
    }

    fun setMessage(message: String): WhatsappIntentBuilder {
        this.message = message
        return this
    }

    fun build(): Intent {
        val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
        val encodedMessage = URLEncoder.encode(message, "UTF-8")
        return Intent(Intent.ACTION_VIEW, Uri.parse("$url&text=$encodedMessage"))
    }
}
