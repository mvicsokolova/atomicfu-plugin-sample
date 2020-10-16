buildscript {

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        // local version from `atomicfu-compiler-plugin-1.4.M2` branch
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
}

kotlin {
    sourceSets {
        js().compilations["main"].defaultSourceSet {
            dependencies {
                compileOnly(kotlin("stdlib-js"))

                // `kotlinx-atomicfu` is applied, but kotlin-js plugin id was not found, so atomicfu-js dependency is added manually
                implementation("org.jetbrains.kotlinx:atomicfu-js:0.14.4")

            }
        }
    }
}