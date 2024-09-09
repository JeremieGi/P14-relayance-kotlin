Feature: Ajout d'un client
    Ajout d'un client dans la liste des clients


    Scenario Outline: Add
         # chaque ligne ici se nomme un step
        Given fenetre de lancement
        When clic sur bouton Plus
        Then fenetre d ajout affichee

        #Section Examples obligatoire (meme si inutile) sinon le test ne se lance pas
        Examples:
            | name | email    |
            | jeremie  | jeremie@free.fr |


