package com.kmm.network.ktor

import com.kmm.network.NetworkDataState
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*
import kotlinx.serialization.SerializationException

suspend inline fun <reified T> HttpClient.safeRequest(
    block: HttpRequestBuilder.() -> Unit
) = try {
    NetworkDataState.Success<T>(request(block).body())
} catch (e: ClientRequestException) {
    NetworkDataState.Error(e.message)
} catch (e: ServerResponseException) {
    NetworkDataState.Error(e.message)
} catch (e: IOException) {
    NetworkDataState.Error(e.message.toString())
} catch (e: SerializationException) {
    NetworkDataState.Error(e.message.toString())
}