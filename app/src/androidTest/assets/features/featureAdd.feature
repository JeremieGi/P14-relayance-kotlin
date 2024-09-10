Feature: Ajout d'un client
    Ajout d'un client dans la liste des clients

    @ScenarioFenetreDeLancement
    Scenario: Affichage de la fenetre d'ajout
         # chaque ligne ici se nomme un step
        Given fenetre de lancement ouverte avec les clients initiaux
        When clic sur bouton Plus
        Then fenetre d ajout affichee


    @ScenarioFenetreDeLancement
    Scenario: Ajout d'un client avec succès
        Given fenetre de lancement ouverte avec les clients initiaux
        When clic sur bouton Plus
        Then fenetre d ajout affichee
        When je saisis comme nom "jeremie"
        And je saisis comme email "jeremie@free.fr"
        And je clique sur enregistrer
        Then la fenêtre principale s'affiche avec un élément de plus


    @ScenarioFenetreAjout
    Scenario: Champ Nom obligatoire
        Given fenetre d ajout affichee
        When je saisis comme nom ""
        And je saisis comme email "jeremie@free.fr"
        And je clique sur enregistrer
        Then un message indique que le nom est obligatoire

    @ScenarioFenetreAjout
    Scenario: Champ Email obligatoire
        Given fenetre d ajout affichee
        When je saisis comme nom "jeremie"
        And je saisis comme email ""
        And je clique sur enregistrer
        Then un message indique que le mail est obligatoire

    @ScenarioFenetreAjout
    Scenario Outline: Champ Email incorrect
        Given fenetre d ajout affichee
        When je saisis comme nom "jeremie"
        And je saisis comme email "<incorrectEmailP>"
        And je clique sur enregistrer
        Then un message indique que le mail est incorrect

        Examples:
            | incorrectEmailP    |
            | incorrectEmail.com |
            | user@domain        |
            | @missingdomain.com |