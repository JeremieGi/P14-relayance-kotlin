package com.kirabium.relayance

import com.kirabium.relayance.repository.CustomersRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class CustomersRepositoryTest {

    /*
    @Test
    fun generateDate_classic() {

        // Prépare le calendrier simulé pour une date spécifique
        val fixedCalendar = Calendar.getInstance()
        fixedCalendar.set(2024, Calendar.SEPTEMBER, 1)

        // Résultat attendu
        val expectedCalendar = Calendar.getInstance()
        expectedCalendar.set(2024, Calendar.JUNE, 1)
        val expectedDate = expectedCalendar.time

        // TODO 1 Denis : Je ne suis pas arrivé à mocker le calendar => j'ai passé la variable Calendar en paramètre
        mockkStatic(Calendar::class)
        every { Calendar.getInstance() } returns fixedCalendar

        // Test de la fonction
        val resultDate = generateDate(3)

        // Validez que la date générée est correcte
        assertEquals(expectedDate, resultDate)

    }
    */


    @Test
    fun generateDate_classic() {

        // J'ai passé le calendar en paramètre de generateDate ce qui simplifie grandement le code

        // Prépare le calendrier simulé pour une date spécifique
        val paramCalendar = Calendar.getInstance()
        paramCalendar.set(Calendar.SECOND, 0)       // Parois des différences lors de l'assert final si je ne fais pas çà
        paramCalendar.set(Calendar.MILLISECOND, 0)
        paramCalendar.set(2024, Calendar.SEPTEMBER, 1)

        // Résultat attendu (moins 3 mois)
        val expectedCalendar = Calendar.getInstance()
        expectedCalendar.set(2024, Calendar.JUNE, 1)
        expectedCalendar.set(Calendar.SECOND, 0)
        expectedCalendar.set(Calendar.MILLISECOND, 0)
        val expectedDate = expectedCalendar.time

        // Test de la fonction
        val resultDate = CustomersRepository.generateDate(3, paramCalendar)

        // Validez que la date générée est correcte
        assertEquals(expectedDate, resultDate)

    }

    @Test
    fun generateDate_param0() {

        // Prépare le calendrier simulé pour une date spécifique
        val paramCalendar = Calendar.getInstance()
        paramCalendar.set(2024, Calendar.SEPTEMBER, 1)
        paramCalendar.set(Calendar.SECOND, 0)
        paramCalendar.set(Calendar.MILLISECOND, 0)

        val expectedDate = paramCalendar.time // Résultat = au paramètre


        // Test de la fonction
        val resultDate = CustomersRepository.generateDate(0, paramCalendar)

        // Validez que la date générée est correcte
        assertEquals(expectedDate, resultDate)

    }

    @Test
    fun generateDate_paramNegative() {

        // Prépare le calendrier simulé pour une date spécifique
        val paramCalendar = Calendar.getInstance()
        paramCalendar.set(2024, Calendar.SEPTEMBER, 1)
        paramCalendar.set(Calendar.SECOND, 0)
        paramCalendar.set(Calendar.MILLISECOND, 0)

        // Résultat attendu (+ 12 mois = - (-12))
        val expectedCalendar = Calendar.getInstance()
        expectedCalendar.set(2025, Calendar.SEPTEMBER, 1)
        expectedCalendar.set(Calendar.SECOND, 0)
        expectedCalendar.set(Calendar.MILLISECOND, 0)
        val expectedDate = expectedCalendar.time

        // Test de la fonction
        val resultDate = CustomersRepository.generateDate(-12, paramCalendar)

        // Validez que la date générée est correcte
        assertEquals(expectedDate, resultDate)

    }




}