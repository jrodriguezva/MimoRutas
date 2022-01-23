pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "MimoRutas"


include(":androidApp")
include(":shared")


enableFeaturePreview("VERSION_CATALOGS")
include(":iosApp")
