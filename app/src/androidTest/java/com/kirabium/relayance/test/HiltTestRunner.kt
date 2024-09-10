package com.kirabium.relayance.test

import android.app.Application
import android.content.Context

import dagger.hilt.android.testing.HiltTestApplication
import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

/**
 * Pour utiliser l'application de test Hilt dans les tests d'instrumentation, vous devez configurer un nouveau lanceur de test.
 * Ce lanceur permet à Hilt de fonctionner pour tous les tests d'instrumentation de votre projet.
 *
 * Cette classe est référencée dans le build.gradle : testInstrumentationRunner = "com.kirabium.relayance.test.HiltTestRunner"
 */

@CucumberOptions(
    features = ["features"],
    glue = ["com.kirabium.relayance.test"]
)
class HiltTestRunner : CucumberAndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }

}
