package com.kirabium.relayance.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Ignore
import org.junit.Rule
import javax.inject.Inject
import com.kirabium.relayance.R

// Doc officielle : https://developer.android.com/training/dependency-injection/hilt-testing

@HiltAndroidTest
class FeatureHiltTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    // Lancement de l'activité principale en début de test
    @get:Rule(order = 1)
    var activityTest = ActivityScenarioRule(MainActivity::class.java)
//
////    @Rule(order = 0)
////    @JvmField
////    val hiltRule = HiltAndroidRule(this)
//
////    @Inject
////    lateinit var greetingService: GreetingService
//
//
//
////    @Before
////    fun setUp() {
////        // Injecte les dépendances avant chaque test
////        hiltRule.inject()
////
////        // Lancement manuel de l'activité après injection Hilt
////        ActivityScenario.launch(MainActivity::class.java)
////    }
//
//
//    @Given("^la fenêtre principale est ouverte$")
//    fun laFenetrePrincipaleEstOuverte() {
//        // Vérification que le RecyclerView fait 5 éléments
//        onView(withId(R.id.customerRecyclerView))
//            .check( RecyclerViewItemCountAssertion.withItemCount(5) )
//    }
//
//    @When("^je clique sur ajouter$")
//    fun jeCliqueSurAjouter() {
//        onView(withId(R.id.addCustomerFab))
//            .perform( click() )
//    }
//
//    @Then("^la fenêtre pour ajouter un nouveau client est affichée$")
//    fun laFenetrePourAjouterUnNouveauClientEstAffichee() {
//        onView(withId(R.id.nameEditText))
//            //.check( doesNotExist() )
//            .check(matches(isDisplayed())) // Vérifie si le champ est visible
//    }

}