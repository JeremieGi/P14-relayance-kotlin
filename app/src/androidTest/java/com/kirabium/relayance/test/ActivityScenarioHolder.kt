package com.kirabium.relayance.test

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import io.cucumber.java.After

/**
 * Classe permettant de lancer un activity Compose
 */
class ActivityScenarioHolder {

    private var scenario: ActivityScenario<*>? = null

    fun launch(intent: Intent){
        scenario = ActivityScenario.launch<Activity>(intent)
    }

    /**
     *  Close activity after scenario
     */
    @After
    fun close(){
        scenario?.close()
    }

}
