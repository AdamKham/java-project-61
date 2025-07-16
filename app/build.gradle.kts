plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.sonarqube") version "6.2.0.5505"
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

sonar {
    properties {
        property("sonar.projectKey", "AdamKham_java-project-61")
        property("sonar.organization", "adamkham")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}