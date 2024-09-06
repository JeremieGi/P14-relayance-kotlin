package com.kirabium.relayance


import android.content.Intent
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import com.kirabium.relayance.ui.activity.MainActivity
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Ignore
import org.junit.Rule
import org.junit.runner.RunWith


// https://www.youtube.com/watch?v=vZV6EiSJAfc
// Source de la vidéo : https://github.com/innovationindiaforall/Testing => projet Android_BDD_UI


@SmallTest
@RunWith(AndroidJUnit4::class)
class FeatureAddTest {

    // Lancement de l'activité principale en début de test

//    @get:Rule(order = 1)
//    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @JvmField
    @Rule
    var activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Rule
    lateinit var activity: MainActivity

    @Before()
    fun setup(){
        activityTestRule.launchActivity(Intent())
        activity = activityTestRule.activity
    }

    @After()
    fun finish(){
        activityTestRule.finishActivity()
    }

    /**
     * ^ : Ce symbole indique le début de la chaîne.
     * $ : Ce symbole indique la fin de la chaîne.
     */

    @Given("^fenetre de lancement$")
    fun fenetre_principale() {
        //assertNotNull(activity)
    }

    @When("^clic sur bouton Plus$")
    fun click_plus() {
//        onView(withId(R.id.addCustomerFab))
//            .perform( click() )
    }


    @Then("^fenetre d ajout affichee$")
    @Throws(Throwable::class)
    fun fenetre_d_ajout_affichee() {

//        onView(withId(R.id.nameEditText))
//            //.check( doesNotExist() )
//            .check(matches(isDisplayed())) // Vérifie si le champ est visible

    }



}