plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.realm)
}

kotlin {
    jvmToolchain(21)

    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    androidTarget()

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

        val androidUnitTest by getting {
            dependencies {
                implementation(libs.robolectric)
            }
        }
    }
}

android {
    compileSdk = 35
    namespace = "app.livesets.manager.database"
    defaultConfig {
        minSdk = 21
    }
}