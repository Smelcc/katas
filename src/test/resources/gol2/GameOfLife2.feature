Feature: Game of Life
  - <2 voisins = meurt
  - >3 voisins = meurt
  - 2 ou 3 voisins = survit
  - ==3 voisins = nouvelle cellule

  Scenario: Une cellule vivante
    Given Coordonnée cellule vivante 2,4
    When Itération
    Then Le résultat est vide

  Scenario: Aucune cellule vivante
    Given Coordonnée cellule vivante -1,-1
    When Itération
    Then Le résultat est vide

  Scenario: Trois cellules vivantes en entrée et aucune survit
    Given Coordonnée cellule vivante 1,1;2,2;1,4
    When Itération
    Then Le résultat est vide

  Scenario: Trois cellules vivantes en entrée et aucune survit
    Given Coordonnée cellule vivante 2,2;1,1;1,4
    When Itération
    Then Le résultat est vide

  Scenario: Trois cellules vivantes en entrée et aucune survit
    Given Coordonnée cellule vivante 2,3;1,2;1,5
    When Itération
    Then Le résultat est vide

  Scenario Template: Trois cellules vivantes en entrée, une survit et 2 naissent
    Given Coordonnée cellule vivante <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée      | sortie      |
      | 1,3;2,3;3,3 | 2,2;2,3;2,4 |
      | 1,2;1,3;1,4 | 0,3;1,3;2,3 |
      | 1,1;1,2;1,3 | 0,2;1,2;2,2 |
      | 1,3;1,2;1,4 | 0,3;1,3;2,3 |

  Scenario Template: Quatre cellules vivantes en entrée, deux survivent et quatre naissent
    Given Coordonnée cellule vivante <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée          | sortie                  |
      | 1,1;1,2;1,3;1,4 | 0,2;0,3;1,2;1,3;2,2;2,3 |

  Scenario Template: Trois cellules vivantes en entrée et trois survivent et une naît
    Given Coordonnée cellule vivante <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée      | sortie          |
      | 1,1;1,2;2,2 | 1,1;1,2;2,1;2,2 |
      | 2,2;1,2;1,1 | 1,1;1,2;2,1;2,2 |
      | 1,2;2,2;1,1 | 1,1;1,2;2,1;2,2 |
      | 2,2;1,1;1,2 | 1,1;1,2;2,1;2,2 |
      | 2,1;2,2;3,2 | 2,1;2,2;3,1;3,2 |
      | 3,2;2,2;2,1 | 2,1;2,2;3,1;3,2 |
      | 1,3;2,3;1,2 | 1,2;1,3;2,2;2,3 |
      | 2,3;1,2;1,3 | 1,2;1,3;2,2;2,3 |

  Scenario Template: Trois cellules vivantes en entrée et une survit et une nait
    Given Coordonnée cellule vivante <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée      | sortie  |
      | 1,3;1,5;2,4 | 1,4;2,4 |
      | 3,3;2,2;2,1 | 2,2;3,2 |
      | 2,3;1,2;1,1 | 1,2;2,2 |

  Scenario Template: Quatre cellules vivantes en entrée et deux survivent et deux naissent
    Given Coordonnée cellule vivante <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée          | sortie          |
      | 1,1;2,2;2,3;1,4 | 1,2;1,3;2,2;2,3 |

  Scenario Template: PAF les chocapics
    Given Coordonnée cellule vivante <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée          | sortie      |
      | 0,0;0,1;0,2;1,2 | 0,1;0,2;1,2 |

#  Scenario Template: Une colonne
#   Given Coordonnée <entrée>
#   When Itération
#   Then Le résultat est <sortie>
#
#   Examples: 
#     | entrée              | sortie              |
#     | 1000;1000;1000;0000 | 0000;1000;0000;0000 |
