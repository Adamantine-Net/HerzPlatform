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
