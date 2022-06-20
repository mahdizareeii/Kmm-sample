package com.kmm.domain.di

import com.kmm.domain.viewmodel.AnimalListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainAndroidModule = module {
    viewModel {
        AnimalListViewModel()
    }
}