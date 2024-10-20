plugins {
    id("java")
    kotlin("jvm") version "2.0.0-RC3"
}

group = "com.dng"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}
java {
    sourceCompatibility = JavaVersion.VERSION_14
    targetCompatibility = JavaVersion.VERSION_14
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(14)
}