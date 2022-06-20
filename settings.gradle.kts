pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "My_Application"
include(":androidApp")
include(":shared:network")
include(":shared:repository")
include(":shared:domain")
include(":shared:core")

enableFeaturePreview("VERSION_CATALOGS")