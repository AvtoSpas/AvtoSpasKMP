import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.skie)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            // TODO: test it
            export(projects.features.login)
            export(projects.features.editProfile)
            export(projects.features.main)
            export(projects.features.orders)
            export(projects.features.settings)
            export(projects.features.support)

        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.features.login)
            api(projects.features.editProfile)
            api(projects.features.main)
            api(projects.features.orders)
            api(projects.features.settings)
            api(projects.features.support)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.avtospaskmp"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

skie {
    features {
        enableFutureCombineExtensionPreview = true
        enableFlowCombineConvertorPreview = true
        enableSwiftUIObservingPreview = true
    }

    analytics {
        enabled.set(false)
    }
}
