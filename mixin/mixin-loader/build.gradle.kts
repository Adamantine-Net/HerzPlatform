plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.ow2.asm:asm:9.7")
    implementation("org.ow2.asm:asm-tree:9.7")
    implementation("org.ow2.asm:asm-commons:9.7")
}

application {
    mainClass.set("net.ada.mixin.weaver.MixinWeaver")
}
tasks.register("buildDependencyJar") {
    description = "Builds a jar of the mixin loader to use as a dependency in projects"
    group="dependency-manager"
    dependsOn(tasks.named<Jar>("jar"))
    doLast {
        copy {
            from(layout.buildDirectory.dir("libs"))
            into(layout.projectDirectory.dir("output/dist"))
            include("*.jar")
        }
    }
}