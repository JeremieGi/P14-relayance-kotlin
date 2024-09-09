// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    //id("jacoco")
}

//buildscript {
//
//    dependencies {
//
//        classpath("com.android.tools.build:gradle:7.0.4")
//
////        //Jacoco Plugin
////        classpath("org.jacoco:org.jacoco.core:0.8.10")
//    }
//
//}

//apply(from = "${project.rootDir}/jacoco.gradle")