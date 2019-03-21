Feature: One Two Reverse

  Scenario Template: des 2 et des 1
    Given entrée <entree>
    When transformation inversée
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                  | resultatAttendu |
      | un deux deux un         | 2 1 1           |
      | un deux deux un un deux | 2 1 1 2         |

  Scenario Template: uniquement des 2
    Given entrée <entree>
    When transformation inversée
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree            | resultatAttendu     |
      | un deux           | 2                   |
      | deux deux         | 2 2                 |
      | neuf deux un deux | 2 2 2 2 2 2 2 2 2 2 |

  Scenario Template: uniquement des 1
    Given entrée <entree>
    When transformation inversée
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                        | resultatAttendu                                         |
      | un un                         | 1                                                       |
      | deux un                       | 1 1                                                     |
      | trois un                      | 1 1 1                                                   |
      | quatre un                     | 1 1 1 1                                                 |
      | neuf un                       | 1 1 1 1 1 1 1 1 1                                       |
      | neuf un un un                 | 1 1 1 1 1 1 1 1 1 1                                     |
      | neuf un neuf un un un         | 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1                   |
      | neuf un neuf un neuf un un un | 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 |
