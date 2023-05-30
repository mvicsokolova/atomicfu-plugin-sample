buildscript {
    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.20.2-SNAPSHOT")
    }
}

plugins {
    kotlin("jvm") version "1.9.0-RC-223"
    application
}

apply(plugin = "kotlinx-atomicfu")

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}
