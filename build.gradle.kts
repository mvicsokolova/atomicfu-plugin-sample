plugins {
    kotlin("jvm") version "2.0.0" // Local version for debug: 2.1.255-SNAPSHOT
    id("org.jetbrains.kotlinx.atomicfu") version "0.25.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    sourceSets {
        main {
            dependencies {
                kotlin("test")
            }
        }
        test {
            dependencies {
                kotlin("test")
            }
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}