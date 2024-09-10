Feature: Details d'un client
  Scenario: Ouverture du detail d'un client
    # Le lancement de test depuis Feature ou scénario ne marche pas...
    # 'important c'est que çà fonctionne au lancement de la configuration : "Run Tests and Generate Jacoco Report"
    Given Lance la fenetre de details
    When Le nom du client est affiche
    And L'email du client est affiche

