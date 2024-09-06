package com.kirabium.relayance

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["features"]  // Indiquer le chemin relatif au dossier 'assets'
)
class RunCucumberTest