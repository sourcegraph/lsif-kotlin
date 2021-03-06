import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.collections.mapOf

plugins {
    kotlin("jvm")
}

group = "org.example"

repositories {
    mavenCentral()
}

val semanticdbJar: Configuration by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}

dependencies {
    implementation(kotlin("stdlib"))
    semanticdbJar(project(mapOf(
        "path" to ":" + projects.semanticdbKotlinc.name,
        "configuration" to "semanticdbJar"
    )))
}
