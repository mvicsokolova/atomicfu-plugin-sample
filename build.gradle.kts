buildscript {

    repositories {
        mavenLocal()
    }

    dependencies {
        //classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.4-1.4-test")
        classpath("org.jetbrains.kotlin.js:org.jetbrains.kotlin.js.gradle.plugin:1.4.0-local")
    }
}

plugins {
    kotlin("js") version "1.4.0-local"
}

//apply {
//    plugin( "kotlinx-atomicfu" )
//}

group = "org.jetbrains.kotlin"

repositories {
    mavenLocal()
    jcenter()
}

kotlin {
    js(IR)

    sourceSets {
        js().compilations["main"].defaultSourceSet {
            dependencies {
                compileOnly(kotlin("stdlib-js"))
                compileOnly("org.jetbrains.kotlin:atomicfu:1.4.0-local")
            }
        }
    }
}