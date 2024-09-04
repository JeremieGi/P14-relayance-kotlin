package com.kirabium.relayance

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.ui.activity.details.DetailActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// https://www.youtube.com/watch?v=vZV6EiSJAfc

@SmallTest
@RunWith(AndroidJUnit4::class)
class CustomerAddTest {

    // Lancement de l'activité principale en début de test

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var activity: MainActivity

    @Before("@add-feature")
    fun setup() {
        // `onActivity` is used to interact with the activity directly.
        activityScenarioRule.scenario.onActivity { activityInstance ->
            activity = activityInstance
        }
    }

    @After("@add-feature")
    fun tearDown() {
        // `ActivityScenarioRule` automatically closes the activity after the test,
    }

    @Given("^la fenêtre principale est ouverte")
    fun fenetre_principale() {
        assertNotNull(activity)
    }

    @When("^Je clique sur ajouter")
    fun click_plus(email: String) {
        Espresso.onView(withId(R.id.addCustomerFab))
            .perform( click() )
    }
/*
    @And("^I input password \"([^\"]*)\"$")
    fun I_input_password(password: String) {
        Espresso.onView(ViewMatchers.withId(com.examplebdd.R.id.passwordText))
            .perform(ViewActions.typeText(password))
        Espresso.closeSoftKeyboard() // Ensure keyboard is closed after typing
    }

    @And("^I press login button$")
    fun I_press_login_button() {
        Espresso.onView(ViewMatchers.withId(com.examplebdd.R.id.loginBtn))
            .perform(ViewActions.click())
    }

  */
    @Then("^I should see on next activity")
    fun i_should_see_on_next_activity(status: String) {
        activityScenarioRule.scenario.onActivity { activity ->
            assertNotNull(activity) // Vérifie que l'activité est bien lancée
        }
    }


}