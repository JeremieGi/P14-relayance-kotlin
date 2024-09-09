Feature: Ajout d'un client
    Ajout d'un client dans la liste des clients

    @ScenarioFenetreDeLancement
    Scenario: Affichage de la fenetre d'ajout
         # chaque ligne ici se nomme un step
        Given fenetre de lancement ouverte
        When clic sur bouton Plus
        Then fenetre d ajout affichee


    @ScenarioFenetreDeLancement

     #Scenario Outline = > Section Examples obligatoire sinon le test ne se lance pas

    Scenario Outline: Ajout d'un client avec succès

        Given fenetre de lancement ouverte
        When clic sur bouton Plus
        Then fenetre d ajout affichee
        When je saisis comme nom "jeremie"
        And je saisis comme email "jeremie@free.fr"
        And je clique sur enregistrer
        Then la fenêtre principale s'affiche avec un élément de plus
        Examples:
            | Examples:    |
            | example_name |
            | test         |


