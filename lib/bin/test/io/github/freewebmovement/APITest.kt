/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.github.freewebmovement

import kotlin.test.Test
import kotlin.test.assertTrue

class APITest {
    @Test
    @Throws(InterruptedException::class, JSONException::class)
    fun shouldGetQuota() {
        val username = "sammy"
        val password = "1234"
        val api = API()
        api.start(username, password);
        val quota: Quota? = api.quota;
        assert(quota != null);
        if (quota != null) {
            assert(quota.username == username)
        }
        if (quota != null) {
            val new = null
            assert(quota.quota.equals(0))
        }
        if (quota != null) {
            assert(quota.upload.equals(0))
        }
        if (quota != null) {
            assert(quota.download.equals(0))
        }
    }
}