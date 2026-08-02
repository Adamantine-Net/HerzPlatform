plugins {
    base
}

gradle.includedBuilds
    .filter { it.name.startsWith("module-eag-") }
    .forEach { includedBuild ->

        val version = includedBuild.name.removePrefix("module-eag-")

        fun registerAlias(
            name: String,
            targetTask: String,
            descriptionText: String
        ) {
            tasks.register("${name}_$version") {
                group = "eaglercraft $version"
                description = descriptionText

                dependsOn(includedBuild.task(targetTask))
            }
        }

        registerAlias(
            name = "build",
            targetTask = ":build",
            descriptionText = "Builds Eaglercraft $version"
        )

        registerAlias(
            name = "clean",
            targetTask = ":clean",
            descriptionText = "Cleans Eaglercraft $version"
        )

        registerAlias(
            name = "runDesktop",
            targetTask =
                ":target_lwjgl_desktop:eaglercraftDebugRuntime",
            descriptionText =
                "Runs the desktop runtime for Eaglercraft $version"
        )

        registerAlias(
            name = "buildJavaScript",
            targetTask =
                ":target_teavm_javascript:makeMainOfflineDownload",
            descriptionText =
                "Builds the JavaScript client for Eaglercraft $version"
        )

        registerAlias(
            name = "buildWasm",
            targetTask =
                ":target_teavm_wasm_gc:makeMainWasmClientBundle",
            descriptionText =
                "Builds the WASM client for Eaglercraft $version"
        )
    }

subprojects
    .filter { it.name.startsWith("mixins-") }
    .forEach { mixinsProject ->

        val version = mixinsProject.name.removePrefix("mixins-")

        tasks.register("compileFull_$version") {
            group = "eaglercraft $version"
            description = "weaves the $version mixins onto the vanilla eagler classes"

            dependsOn("${mixinsProject.path}:compileFull")
        }

        tasks.register("buildFull_$version") {
            group = "eaglercraft $version"
            description = "weaves mixins then builds the js client for eag $version"

            dependsOn("compileFull_$version")
            dependsOn("buildJavaScript_$version")
        }
    }

tasks.register("buildAllEagler") {
    group = "eaglercraft"
    description = "Builds every Eaglercraft version"

    dependsOn(
        tasks.matching {
            it.name.startsWith("build_") &&
                    it.name != "buildAllEagler"
        }
    )
}

tasks.register("cleanAllEagler") {
    group = "eaglercraft"
    description = "Cleans every Eaglercraft version"

    dependsOn(
        tasks.matching {
            it.name.startsWith("clean_") &&
                    it.name != "cleanAllEagler"
        }
    )
}
