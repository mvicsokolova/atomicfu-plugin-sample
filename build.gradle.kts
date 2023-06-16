buildscript {
    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.20.2")
    }
}

plugins {
    //kotlin("jvm") version "1.9.20-dev-3828"
    kotlin("jvm") version "1.9.255-SNAPSHOT-jvm"
    //kotlin("jvm") version "1.8.20"
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
