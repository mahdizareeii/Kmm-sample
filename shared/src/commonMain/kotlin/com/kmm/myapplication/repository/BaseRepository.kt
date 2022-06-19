package com.kmm.myapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository(
    protected val dispatcher: CoroutineContext = Dispatchers.Default
) {
    protected val baseUrl = "https://zoo-animal-api.herokuapp.com/"
}