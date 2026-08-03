evaluationDependsOn(":mixin:mixin-loader")

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val eaglerModule = gradle.includedBuild("module-eag-1_5_2")
val vanillaClassesDir = rootDir.resolve("modules/module-eag-1_5_2/build/classes/java/main")

sourceSets {
    named("main") {
        java.srcDir(rootDir.resolve("src/common/java"))
        java.exclude("net/ada/main/**")
        java.exclude("net/ada/v1_8/**")
        java.exclude("net/ada/v1_14/**")
        java.exclude("net/ada/v1_5_2/worldgen/**")//whoopty do
        java.exclude("net/ada/v1_5_2/persist/**")//whoopty do
    }
}

dependencies {
    compileOnly(files(vanillaClassesDir))
    implementation(project(":mixin:mixin-loader"))
}

tasks.named<JavaCompile>("compileJava") {
    dependsOn(eaglerModule.task(":compileJava"))
}

tasks.register("compileMixins") {
    group = "mixins"
    description = "Compiles the 1.5.2 mixin classes"
    dependsOn(tasks.named("compileJava"))
}

val wovenClassesDir = layout.buildDirectory.dir("full/classes")

val compileFull = tasks.register<JavaExec>("compileFull") {
    group = "mixins"
    description = "Applies the 1.5.2 mixins onto the vanilla eagler classes"

    dependsOn(tasks.named("compileMixins"))
    dependsOn(eaglerModule.task(":compileJava"))
    dependsOn(":mixin:mixin-loader:compileJava")

    classpath = files(
        project(":mixin:mixin-loader").sourceSets["main"].runtimeClasspath
    )
    mainClass.set("net.ada.mixin.weaver.MixinWeaver")

    doFirst {
        args = listOf(
            tasks.named<JavaCompile>("compileJava").get().destinationDirectory.get().asFile.path,
            vanillaClassesDir.path,
            wovenClassesDir.get().asFile.path
        )
    }

    outputs.dir(wovenClassesDir)
}

tasks.named("build") {
    dependsOn(compileFull)
}
