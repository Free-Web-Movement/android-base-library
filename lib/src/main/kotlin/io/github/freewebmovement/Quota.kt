package io.github.freewebmovement

import java.math.BigInteger

interface Quota {
    val username: String
    val quota: BigInteger
    val upload: BigInteger
    val download: BigInteger
}