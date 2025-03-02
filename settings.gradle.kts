enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AvtoSpasKMP"
include(":androidApp")
include(":shared")
include(":core-ui")

include(
    ":features:login",
    ":features:edit-profile",
    ":features:main",
    ":features:orders",
    ":features:settings",
    ":features:support",
)