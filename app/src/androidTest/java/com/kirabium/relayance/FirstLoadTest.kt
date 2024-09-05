package com.kirabium.relayance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion

@RunWith(AndroidJUnit4::class)
class FirstLoadTest {

    // Lancement de l'activité principale en début de test
    @get:Rule
    var activityTest = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun load5customers() {

        // TODO Denis prio 3 : j'ai parfois des erreurs dans l'enchainements des tests
        //  car le répository n'est pas réinitialisé et qu'il peut y avoir 6 items au lancement du test
        // (si le test d'ajout passe avant)

        // Vérification que le RecyclerView fait 5 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) )

    }

}
