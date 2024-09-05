package com.kirabium.relayance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.kirabium.relayance.ui.activity.add.AddCustomerActivity
import org.junit.Rule
import org.junit.Test

class CustomerAddLimitTest {

    // Lancement de l'activité d'ajout d'un client
    @get:Rule
    var activityTest = ActivityScenarioRule(AddCustomerActivity::class.java)


    @Test
    fun add_noname() {

        // Attendre que le champ de texte ou un autre élément dans la nouvelle fenêtre soit visible
        onView(withId(R.id.nameEditText))
            .check(matches(isDisplayed()))

        // Saisir uniquement un email
        onView(withId(R.id.emailEditText))
            .perform( typeText("clienttest@free.fr") )

        // Clic sur le bouton d'enregistrement
        onView(withId(R.id.saveFab))
            .perform( click() )

        // Obtenir la ressource de chaîne
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val sExpectedErrorNoName = appContext.getString(R.string.name_check)

        // 2 façons de vérifier

        // Vérification que le texte d'erreur apparaît dans la View
        onView(withText(sExpectedErrorNoName)).check(matches(isDisplayed()))

        // Vérification que le texte apparait en tant que descendant du champ TextInputLayout
        onView(withId(R.id.nameTextInputLayout))
            .check(matches(hasDescendant(withText(sExpectedErrorNoName))))

    }


    @Test
    fun add_badmailformat() {

        // Attendre que le champ de texte ou un autre élément dans la nouvelle fenêtre soit visible
        onView(withId(R.id.nameEditText))
            .check(matches(isDisplayed()))

        // Saisir un nom
        onView(withId(R.id.nameEditText))
            .perform( typeText("client test") )

        // Saisir uniquement un email incorrect
        onView(withId(R.id.emailEditText))
            .perform( typeText("clienttest@free") ) // pas de .fr

        // Clic sur le bouton d'enregistrement
        onView(withId(R.id.saveFab))
            .perform( click() )

        // Obtenir la ressource de chaîne
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val sExpectedErrorMail = appContext.getString(R.string.invalid_format)

        // 2 façons de vérifier

        // Vérification que le texte d'erreur apparaît dans la View
        onView(withText(sExpectedErrorMail)).check(matches(isDisplayed()))

        // Vérification que le texte apparait en tant que descendant du champ TextInputLayout
        onView(withId(R.id.emailTextInputLayout))
            .check(matches(hasDescendant(withText(sExpectedErrorMail))))

    }


    @Test
    fun add_nomail() {

        // Attendre que le champ de texte ou un autre élément dans la nouvelle fenêtre soit visible
        onView(withId(R.id.nameEditText))
            .check(matches(isDisplayed()))

        // Saisir uniquement un nom
        onView(withId(R.id.nameEditText))
            .perform( typeText("client test") )

        // Clic sur le bouton d'enregistrement
        onView(withId(R.id.saveFab))
            .perform( click() )

        // Obtenir la ressource de chaîne
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val sExpectedErrorNoMail = appContext.getString(R.string.mail_check)

        // 2 façons de vérifier

        // Vérification que le texte d'erreur apparaît dans la View
        onView(withText(sExpectedErrorNoMail)).check(matches(isDisplayed()))

        // Vérification que le texte apparait en tant que descendant du champ TextInputLayout
        onView(withId(R.id.emailTextInputLayout))
            .check(matches(hasDescendant(withText(sExpectedErrorNoMail))))

    }

}

