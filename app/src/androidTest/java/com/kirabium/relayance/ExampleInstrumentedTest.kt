package com.kirabium.relayance

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

// TODO Denis : Je n'ai pas la possibilité de lancer les tests instrumentés directement depuis l'arborescence de droite (comme avec les tests unitaires)
// => J'ai du créé une configuration dédiée "Tests with Coverage"

// TODO Denis : Pour les rendus, il est demandé un fichier html (compte-rendu de test) mais il faut tous les fichiers liés
// TODO Denis : L'exercice 1 et 2 => Même lien GitHub

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.kirabium.relayance", appContext.packageName)
    }
}