plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.kmm.myapplication.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            //if you did want to enable proguard/r8 do not forget add kotlin-serialization rules
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.android.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constariantlayout)
    implementation(libs.koin.kotlin.core)
    implementation(libs.koin.kotlin.android)
}