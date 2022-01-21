buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://kotlin.bintray.com/ktor")
    }
    dependencies {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
                as org.gradle.accessors.dm.LibrariesForLibs
        classpath(libs.bundles.gradlePlugins)
        classpath(kotlin("gradle-plugin", libs.versions.kotlin.get()))
    }
}

group = "com.jrodriguezva.mimorutas"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://kotlin.bintray.com/ktor")
    }
}
