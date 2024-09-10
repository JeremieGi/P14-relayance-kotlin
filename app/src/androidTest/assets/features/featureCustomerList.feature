Feature: Liste les clients
  Affiche la liste des clients

  @ScenarioFenetreDeLancement
  Scenario: Affichage de la liste des clients
    Given fenetre de lancement ouverte avec les clients initiaux

  @ScenarioFenetreDeLancement
  Scenario: Clic sur un élément ouvre le détail
    Given fenetre de lancement ouverte avec les clients initiaux
    When clic sur le premier élément de la liste
    Then la fenetre de detail est lancée avec le bon ID