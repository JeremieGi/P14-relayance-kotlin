package com.kirabium.relayance.test

import androidx.compose.ui.test.junit4.createEmptyComposeRule
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

/**
 * Classe permettant d'utiliser @get:Rule dans Cucumber avec Compose
 */
@WithJunitRule
class ComposeRuleHolder {

    @get:Rule(order = 1)
    val composeRule = createEmptyComposeRule()

}