plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}

group = "com.jrodriguezva.mimorutas"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //Network
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.content.negotiation)

                //Coroutines
                implementation(libs.kotlinx.coroutines.core)
                //Logger
                implementation(libs.napier)
                //JSON
                implementation(libs.kotlinx.serialization.json)
                //Key-Value storage
                implementation(libs.multiplatform.settings)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.5.0")
                implementation(libs.ktor.client.okhttp)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")

            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                //Network
                implementation(libs.ktor.client.ios)
            }
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

multiplatformSwiftPackage {
    packageName("MimoRutas")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }
    }
}