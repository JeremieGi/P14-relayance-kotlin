package com.kirabium.relayance.test

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kirabium.relayance.R
import com.kirabium.relayance.ui.activity.details.DetailActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import io.cucumber.java.After
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import org.junit.Rule


class StepListTest {

    // Ajoutez explicitement IntentsRule à vos tests
    // pour assurer une configuration correcte et une libération des ressources.
    @get:Rule
    var intentsRule = IntentsRule()


    @When("clic sur le premier élément de la liste")
    fun clickSurLePermierElementDeLaListe() {

        Intents.init() // Initialiser les Intents manuellement

        // Vérification que le RecyclerView fait 5 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) ) // TODO Denis : Il s'agit d'une méthode créée spcialement pour le test ?
            // Clic sur le 1er élément
            .perform( RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())  )

    }

    @Then("la fenetre de detail est lancée avec le bon parametre")
    fun laFenetreDeDetailEstLanceeAvecLeBonID() {

        // Vérifiez que l'Intent a été généré
        intended( hasComponent(DetailActivity::class.java.name) )

        // avec l'ID client
        intended(hasExtraWithKey(DetailActivity.EXTRA_CUSTOMER_ID))

    }

    @After
    fun tearDown() {
        Intents.release() // Libérer les Intents après le test
    }

}