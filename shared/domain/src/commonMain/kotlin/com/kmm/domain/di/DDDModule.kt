package com.kmm.domain.di

import com.kmm.network.di.networkCommonModule
import com.kmm.repository.di.repositoryCommonModule

val DDDModule = arrayOf(
    networkCommonModule,
    repositoryCommonModule,
    domainCommonModule
)