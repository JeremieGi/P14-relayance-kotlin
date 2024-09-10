Feature: Détails du client

  Scenario: Affichage des détails du client
    Given La fenêtre de détail est lancée avec l'ID client 1
    When Je suis sur l'écran de détails du client
    Then Le nom du client est affiché
    And L'email du client est affiché