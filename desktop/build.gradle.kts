plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
}

group = "app.example"
version = "1.0.0"

kotlin {
    jvmToolchain(21)
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        jvmMain {
            dependencies {
                api(compose.foundation)
                api(compose.desktop.currentOs)

                implementation(project(":database"))
            }
        }
    }
}

compose {
    desktop {
        // for config documentation
        // https://github.com/JetBrains/compose-jb/blob/master/tutorials/Native_distributions_and_local_execution/README.md
        application {
            mainClass = "app.livesets.manager.desktop.MainKt"
        }
    }
}
