package com.kirabium.relayance.test

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.ui.activity.details.DetailActivity
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.kirabium.relayance.R

@RunWith(AndroidJUnit4::class)
class ClickFirstElementIntentTest {

    // Doc : https://developer.android.com/training/testing/espresso/intents?hl=fr#kotlin

    // Lancement de l'activité principale en début de test
    @get:Rule
    var activityTest = ActivityScenarioRule(MainActivity::class.java)

    // Ajoutez explicitement IntentsRule à vos tests pour assurer une configuration correcte et une libération des ressources.
    @get:Rule
    var intentsRule = IntentsRule()

    @Before
    fun intRepository(){

    }

    @Test
    fun clickAndTestIntent() {

        // Vérification que le RecyclerView fait 5 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) ) // TODO Denis : Il s'agit d'une méthode créée spcialement pour le test ?
            // Clic sur le 1er élément
            .perform( RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())  )


        // Vérifiez que l'Intent a été généré
        intended( hasComponent(DetailActivity::class.java.name) )

        // avec l'ID client
        intended(hasExtraWithKey(DetailActivity.EXTRA_CUSTOMER_ID))


    }

}