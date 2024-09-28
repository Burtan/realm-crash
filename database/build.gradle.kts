plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.realm)
}

kotlin {
    jvmToolchain(21)

    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.coroutines.core)

                // database
                implementation(libs.realm)
            }
        }
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotest.assertions.core)
                implementation(libs.coroutines.test)
            }
        }

        jvmMain {
            dependencies {
                // for Dispatchers.Main on compose desktop
                implementation(libs.coroutines.swing)
            }
        }
    }
}
