package io.github.freewebmovement

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

class OKAPI {
    private var httpClient = OkHttpClient()
    fun quota(username: String?, password: String?): String {
        val formBody: RequestBody = FormBody.Builder()
            .add("username", username)
            .add("password", password)
            .build()
        val request: Request = Request.Builder()
            .url(API.Companion.BASE_URL + "user/quota")
            .post(formBody)
            .build()
        val call = httpClient.newCall(request)
        return try {
            val response = call.execute()
            response.body()!!.string()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    companion object {
        var BASE_URL = "https://games.yikuaijiasu.top/"
    }
}