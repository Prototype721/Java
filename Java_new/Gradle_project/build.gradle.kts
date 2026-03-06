import java.time.LocalDateTime
import java.util.Properties


plugins {
    id("java")
    application
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "my.group.id"
version = "1.0-SNAPSHOT"

application {
    mainClass = "org.example.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":string-utils"))

    implementation("org.apache.commons:commons-lang3:3.14.0")

    implementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("org.slf4j:slf4j-api:2.0.9")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    manifest {
        attributes(Pair("Main-Class", "org.example.Main"))
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

abstract class PrintInfoTask : DefaultTask() {
    @TaskAction
    fun print() {
        println("------------------------------")
        println("Это моя первая пользовательская задача!")
        println("Проект: ${project.name}")
        println("Версия Gradle: ${project.gradle.gradleVersion}")
        println("-------------------------------")
    }
}

tasks.register<PrintInfoTask>("printInfo") {
    group = "Custom"
    description = "Выводит информацию о проекте"
}


abstract class GenerateBuildInfoTask : DefaultTask() {

    @get:Input
    val gitCommitHash: Property<String> = project.objects.property(String::class.java)

    @TaskAction
    fun generate() {

        val resourcesDir = File(project.projectDir, "src/main/resources")
        resourcesDir.mkdirs()

        val passportFile = File(resourcesDir, "build-passport.properties")

        val buildNumberFile = File(project.projectDir, "build-number.txt")

        var buildNumber = 1
        if (buildNumberFile.exists()) {
            buildNumber = buildNumberFile.readText().trim().toInt() + 1
        }

        buildNumberFile.writeText(buildNumber.toString())

        val props = Properties()

        val user =
            System.getenv("USERNAME")
                ?: System.getenv("USER")
                ?: "unknown"

        props["user"] = user
        props["os"] = System.getProperty("os.name")
        props["java"] = System.getProperty("java.version")
        props["datetime"] = LocalDateTime.now().toString()
        props["message"] = "Hello from Gradle build!"
        props["gitCommit"] = gitCommitHash.get()
        props["buildNumber"] = buildNumber.toString()

        passportFile.writer().use {
            props.store(it, "Build Passport")
        }

        println("Build passport generated")
    }
}

val gitHashProvider = providers.exec {
    commandLine("git", "rev-parse", "--short", "HEAD")
}.standardOutput.asText.map { it.trim() }

tasks.register<GenerateBuildInfoTask>("generateBuildInfo") {
    gitCommitHash = gitHashProvider
}

tasks.named("processResources") {
    dependsOn(tasks.named("generateBuildInfo"))
}