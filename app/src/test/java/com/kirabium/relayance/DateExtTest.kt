package com.kirabium.relayance

import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class DateExtTest {

    @Test
    fun toHumanDate_classic() {

        // J'ai passé le calendar en paramètre de generateDate ce qui simplifie grandement le code

        // Prépare le calendrier
        val paramCalendar = Calendar.getInstance()

        // Date spécifique
        paramCalendar.set(2024, Calendar.SEPTEMBER, 1)
        val cutDate = paramCalendar.time

        val result = cutDate.toHumanDate()

        // Validez que la date générée est correcte
        assertEquals("01/09/2024", result)

    }


}