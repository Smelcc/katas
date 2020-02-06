Feature: Bus - http://codingdojo.org/kata/Bus/

  Scenario: Deux chauffeurs de bus qui commencent au même arret
    Given Un chauffeur avec pour route 1
    And Un chauffeur avec pour route 1
    When Il termine son parcours
    Then Il a tous les ragots au 1 arrêt

  Scenario: Deux chauffeurs de bus qui ne commencent pas au même arret
    Given Un chauffeur avec pour route 2
    And Un chauffeur avec pour route 1
    When Il termine son parcours
    Then Ils n'ont pas tous les ragots

  Scenario: Deux chauffeurs de bus qui ne commencent pas au même arret
    Given Un chauffeur avec pour route 3
    And Un chauffeur avec pour route 1
    When Il termine son parcours
    Then Ils n'ont pas tous les ragots

  Scenario: Deux chauffeurs de bus qui ne commencent au même arret
    Given Un chauffeur avec pour route 2
    And Un chauffeur avec pour route 2
    When Il termine son parcours
    Then Il a tous les ragots au 1 arrêt

  Scenario: Deux chauffeurs de bus qui ne commencent pas au même arret et qui ne croisent pas
    Given Un chauffeur avec pour route 32
    And Un chauffeur avec pour route 13
    When Il termine son parcours
    Then Ils n'ont pas tous les ragots

  Scenario Template: Deux chauffeurs de bus qui conduisent et qui parlent
    Given Un chauffeur avec pour route <route1>
    And Un chauffeur avec pour route <route2>
    When Il termine son parcours
    Then Il a tous les ragots au <nb_arret> arrêt

    Examples: 
      | route1 | route2 | nb_arret |
      | 32     | 12     | 2        |
      | 2      | 2      | 1        |
      | 123    | 243    | 3        |
      | 12     | 543    | 0        |
      | 1268   | 543    | 0        |
      | 12     | 541    | 3        |

  Scenario Template: Trois chauffeurs de bus qui conduisent et qui parlent
    Given Un chauffeur avec pour route <route1>
    And Un chauffeur avec pour route <route2>
    And Un chauffeur avec pour route <route3>
    When Il termine son parcours
    Then Il a tous les ragots au <nb_arret> arrêt

    Examples: 
      | route1 | route2 | route3 | nb_arret |
      | 32     | 12     | 42     | 2        |
      | 12     | 1      | 45675  | 0        |
