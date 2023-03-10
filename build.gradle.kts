import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.5.10"
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)

                implementation("io.ktor:ktor-client-core:1.6.4")
                implementation("io.ktor:ktor-client-cio:1.6.4")
                implementation("io.ktor:ktor-client-serialization:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

                implementation("io.ktor:ktor-client-mock:1.6.4")
                implementation(kotlin("test-junit"))
                implementation("com.willowtreeapps.assertk:assertk-jvm:0.25")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.1")

            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "DesktopWeather"
            packageVersion = "1.0.0"
        }
    }
}
