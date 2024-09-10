@file:Suppress("DEPRECATION")

import com.android.build.gradle.BaseExtension

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("jacoco")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}
tasks.withType<Test> {
    extensions.configure(JacocoTaskExtension::class) {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}
android {
    namespace = "com.kirabium.relayance"
    compileSdk = 34

    testCoverage {
        version = "0.8.8"
    }

    defaultConfig {
        applicationId = "com.kirabium.relayance"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testApplicationId = "com.kirabium.relayance.test"
        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "com.kirabium.relayance.test.HiltTestRunner"
       // testInstrumentationRunner="io.cucumber.android.runner.CucumberAndroidJUnitRunner"
        //testInstrumentationRunner = "com.kirabium.relayance.test.Instrumentation"
        //testInstrumentationRunnerArguments(optionsAnnotationPackage: "some.other.package")

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
            isTestCoverageEnabled = true // permet la collecte des données de couverture lors de l'exécution des test
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
//    testOptions {
//        execution = "ANDROIDX_TEST_ORCHESTRATOR"
//    }
}

val androidExtension = extensions.getByType<BaseExtension>()

//jacoco {
//    toolVersion = "0.8.12"
//    //reportsDirectory = layout.buildDirectory.dir('customJacocoReportDir')
//}

// Register a JacocoReport task for code coverage analysis
val jacocoTestReport by tasks.registering(JacocoReport::class) {
    dependsOn("testDebugUnitTest", "createDebugCoverageReport")
    group = "Reporting"
    description = "Generate Jacoco coverage reports"

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    val debugTree = fileTree("${buildDir}/tmp/kotlin-classes/debug")
    val mainSrc = androidExtension.sourceSets.getByName("main").java.srcDirs

    classDirectories.setFrom(debugTree)
    sourceDirectories.setFrom(files(mainSrc))
    executionData.setFrom(fileTree(buildDir) {
        include("**/*.exec", "**/*.ec")
    })
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.intents)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    androidTestImplementation(libs.androidx.espresso.contrib) //  actions sur RecyclerView

    testImplementation(libs.mockk)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.hilt.navigation.fragment)
    kapt(libs.hilt.compiler)
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.51.1")


    // Dépendances Cucumber pour Android
    androidTestUtil("androidx.test:orchestrator:1.5.0")
    androidTestImplementation("io.cucumber:cucumber-junit:7.18.1")
    androidTestImplementation("io.cucumber:cucumber-android:7.18.1")
    androidTestImplementation("io.cucumber:cucumber-java:7.18.1")
    androidTestImplementation("io.cucumber:cucumber-android-hilt:7.18.1")


}
