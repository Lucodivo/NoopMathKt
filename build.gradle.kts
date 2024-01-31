plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
}

group = "com.github.Lucodivo"
version = "v0.2.1-alpha"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}