Feature: One Two

  Scenario Template: des un et des deux
    Given entrée <entree>
    When transformation
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree  | resultatAttendu         |
      | 1 2     | un un un deux           |
      | 2 1     | un deux un un           |
      | 2 2 1 1 | deux deux deux un       |
      | 2 1 2   | un deux un un un deux   |
      | 2 1 2 2 | un deux un un deux deux |

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

  Scenario Template: uniquement des 2
    Given entrée <entree>
    When transformation
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree | resultatAttendu |
      | 2      | un deux         |
      | 2 2    | deux deux       |
      | 2 2 2  | trois deux      |
