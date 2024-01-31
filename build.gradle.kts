plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
}

group = "com.github.Lucodivo"
version = "v0.2.4-alpha"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

java {
    withJavadocJar()
    withSourcesJar()
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("mavenCentral") {
            groupId = "com.github.Lucodivo"
            artifactId = "NoopMathKt"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("NoopMathKt")
                description.set("Linear Algebra Kotlin library for use with OpenGL")
                url.set("https://github.com/lucodivo/NoopMathKt")
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://choosealicense.com/licenses/apache-2.0/")
                    }
                }
                developers {
                    developer {
                        id.set("lucodivo")
                        name.set("Connor A. Haskins")
                        email.set("ConnorAHaskins@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/lucodivo/NoopMathKt.git")
                    developerConnection.set("scm:git:ssh://git@github.com:lucodivo/NoopMathKt.git")
                    url.set("https://github.com/lucodivo/NoopMathKt")
                }
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin.jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
}