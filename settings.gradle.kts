pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "MimoRutas"


include(":androidApp")
include(":shared")


enableFeaturePreview("VERSION_CATALOGS")