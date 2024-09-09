package com.kirabium.relayance.test

import androidx.test.core.app.ActivityScenario
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
import com.kirabium.relayance.R
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.ui.activity.add.AddCustomerActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Rule
import io.cucumber.java.PendingException
import io.cucumber.java.en.And

@HiltAndroidTest
class StepAddTest {

    @get:Rule(order = 1)
    var hiltRule = HiltAndroidRule(this)

//    // Lancement de l'activité principale en début de test
//    @get:Rule(order = 2)
//    var activityTest = ActivityScenarioRule(MainActivity::class.java)


    @Before("@ScenarioFenetreDeLancement")
    fun launchMainActivity() {
        // Injecte les dépendances avant chaque test
        hiltRule.inject()

        // Lancement manuel de l'activité après injection Hilt
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Before("@ScenarioFenetreAjout")
    fun launchAddCustomerActivity() {
        // Injecte les dépendances avant chaque test
        hiltRule.inject()

        // Lancement manuel de l'activité après injection Hilt
        ActivityScenario.launch(AddCustomerActivity::class.java)
    }


    @Given("fenetre de lancement ouverte")
    fun fenetreDeLancement() {
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) )
    }


    @When("clic sur bouton Plus")
    fun click_plus() {
        onView(withId(R.id.addCustomerFab))
            .perform( click() )
    }


    @Then("fenetre d ajout affichee")
    @Throws(Throwable::class)
    fun fenetre_d_ajout_affichee() {

        onView(withId(R.id.nameEditText))
            //.check( doesNotExist() )
            .check(matches(isDisplayed())) // Vérifie si le champ est visible

    }


    @Given("la fenêtre principale est ouverte")
    fun laFenetrePrincipaleEstOuverte() {
        // Vérification que le RecyclerView fait 5 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) )
    }

    @When("je clique sur ajouter")
    fun jeCliqueSurAjouter() {
        onView(withId(R.id.addCustomerFab))
            .perform( click() )
    }

    @Then("la fenêtre pour ajouter un nouveau client est affichée")
    fun laFenetrePourAjouterUnNouveauClientEstAffichee() {
        onView(withId(R.id.nameEditText))
            //.check( doesNotExist() )
            .check(matches(isDisplayed())) // Vérifie si le champ est visible
    }

    @When("je saisis comme nom {string}")
    fun jeSaisisCommeNom(nameP : String) {
        // Saisir un nom
        onView(withId(R.id.nameEditText))
            .perform( typeText(nameP) )
    }


    @And("je saisis comme email {string}")
    fun jeSaisisCommeEmail(emailP : String) {
        // Saisir un email
        onView(withId(R.id.emailEditText))
            .perform( typeText(emailP) )
    }

    @When("je clique sur enregistrer")
    fun jeCliqueSurEnregistrer() {
        // Clic sur le bouton d'enregistrement
        onView(withId(R.id.saveFab))
            .perform( click() )
    }

    @Then("la fenêtre principale s'affiche avec un élément de plus")
    fun fenetrePincipaleAvecClientAjout() {
        // Vérification que le RecyclerView fait maintenant 6 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(6) )
    }


    @Then("un message indique que le nom est obligatoire")
    fun unMessageIndiqueQueLeNomEstObligatoire() {

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
}