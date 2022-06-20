package com.kmm.repository

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository(
    protected val dispatcher: CoroutineContext = Dispatchers.Default
)