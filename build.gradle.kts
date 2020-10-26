buildscript {

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.4-1.4-test")
        // local version of kotlin with `atomicfu` compiler plugin, from `sokolova/atomicfu-plugin` branch, rebased on the current master
        classpath("org.jetbrains.kotlin.js:org.jetbrains.kotlin.js.gradle.plugin:1.4.0-local")
    }
}

plugins {
    kotlin("js") version "1.4.0-local"
}

apply {
    plugin( "kotlinx-atomicfu" )
}

repositories {
    mavenLocal()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-dev")
    }
}

kotlin {
    sourceSets {
        js().compilations["main"].defaultSourceSet {
            dependencies {
                compileOnly(kotlin("stdlib-js"))
            }
        }

        js().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}