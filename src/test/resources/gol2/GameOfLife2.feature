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

  Scenario: Deux cellules vivantes
    Given Coordonnée cellule vivante 2,4;2,3;2,2
    When Itération
    Then Le résultat est 2,3

  Scenario: Trois cellules vivantes en entrée et une survit
    Given Coordonnée cellule vivante 1,3;2,3;3,3
    When Itération
    Then Le résultat est 2,3

  Scenario: Trois cellules vivantes en entrée et une survit
    Given Coordonnée cellule vivante 1,2;1,3;1,4
    When Itération
    Then Le résultat est 1,3

  Scenario: Trois cellules vivantes en entrée et une survit
    Given Coordonnée cellule vivante 1,1;1,2;1,3
    When Itération
    Then Le résultat est 1,2

  Scenario: Quatre cellules vivantes en entrée et deux survivent
    Given Coordonnée cellule vivante 1,1;1,2;1,3;1,4
    When Itération
    Then Le résultat est 1,2;1,3

  Scenario: Trois cellules vivantes en entrée et une survit
    Given Coordonnée cellule vivante 1,3;1,2;1,4
    When Itération
    Then Le résultat est 1,3
    
    Scenario: Trois cellules vivantes en entrée et aucune survit
    Given Coordonnée cellule vivante 1,1;2,2;1,4
    When Itération
    Then Le résultat est vide
    
    
#  Scenario Template: Une colonne
#   Given Grille <entrée>
#   When Itération
#   Then Le résultat est <sortie>
#
#   Examples: 
#     | entrée              | sortie              |
#     | 1000;1000;1000;0000 | 0000;1000;0000;0000 |
