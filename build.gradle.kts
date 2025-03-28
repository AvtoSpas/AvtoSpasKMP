plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
}

buildscript {
    dependencies {
        classpath(libs.resources.generator)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.yandex.ru") // убираем `url = uri(...)`
    }
}
