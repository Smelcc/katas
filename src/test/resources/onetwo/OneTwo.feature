Feature: One Two

  Scenario Template: uniquement des 1
    Given entrée <entree>
    When transformation
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree            | resultatAttendu |
      | 1                 | un un           |
      | 1 1               | deux un         |
      | 1 1 1             | trois un        |
      | 1 1 1 1           | quatre un       |
      | 1 1 1 1 1 1 1 1 1 | neuf un         |
