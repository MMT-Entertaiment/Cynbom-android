package net.mmt_entertaiment.cynbom.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            val request = chain.request()
            chain.proceed(request)
        } catch (e: IOException) {
            // Erreur de connexion réseau
            throw e
        }
    }
}
