plugins {
    `java`
    id("groovy")
    id("maven-publish")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.1.0"
    kotlin("jvm") version "1.9.0"
}

group = "net.kingmc"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.codehaus.groovy:groovy:3.0.11")
    compileOnly(gradleApi())
    compileOnly(localGroovy())
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    testImplementation(kotlin("test"))
}

gradlePlugin {
    website = "https://github.com/Kingsthere/kingmc-gradle-plugin"
    vcsUrl = "https://github.com/Kingsthere/kingmc-gradle-plugin"

    plugins {
        create("kingmc") {
            id = "net.kingmc.kingmc-gradle-plugin"
            tags = listOf("kingmc", "minecraft")
            displayName = "KingMC Gradle Plugin"
            description = "Gradle plugin for configuring kingmc framework"
            implementationClass = "kingmc.gradle.KingMCPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.compileTestKotlin {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
