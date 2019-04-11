Feature: Game of Life
  - <2 voisins = meurt
  - >3 voisins = meurt
  - 2 ou 3 voisins = survit
  - ==3 voisins = nouvelle cellule

  Scenario Template: Une colonne
    Given Grille <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée              | sortie              |
      | 1000;1000;1000;0000 | 0000;1000;0000;0000 |
      | 0000;1000;1000;1000 | 0000;0000;1000;0000 |
      | 1000;0000;1000;1000 | 0000;0000;0000;0000 |
      | 1000;1000;1000;1000 | 0000;1000;1000;0000 |
      | 0100;0100;0100;0100 | 0000;0100;0100;0000 |
      | 0010;0010;0010;0010 | 0000;0010;0010;0000 |
      | 0001;0001;0001;0001 | 0000;0001;0001;0000 |

  Scenario Template: Une ligne
    Given Grille <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée              | sortie              |
      | 1011;0000;0000;0000 | 0000;0000;0000;0000 |
      | 1001;0000;0000;0000 | 0000;0000;0000;0000 |
      | 0001;0000;0000;0000 | 0000;0000;0000;0000 |
      | 1000;0000;0000;0000 | 0000;0000;0000;0000 |
      | 1110;0000;0000;0000 | 0100;0000;0000;0000 |
      | 0111;0000;0000;0000 | 0010;0000;0000;0000 |
      | 1111;0000;0000;0000 | 0110;0000;0000;0000 |
      | 1010;0000;0000;0000 | 0000;0000;0000;0000 |
      | 0000;1011;0000;0000 | 0000;0000;0000;0000 |
      | 0000;1001;0000;0000 | 0000;0000;0000;0000 |
      | 0000;0001;0000;0000 | 0000;0000;0000;0000 |
      | 0000;1000;0000;0000 | 0000;0000;0000;0000 |
      | 0000;1110;0000;0000 | 0000;0100;0000;0000 |
      | 0000;0111;0000;0000 | 0000;0010;0000;0000 |
      | 0000;1111;0000;0000 | 0000;0110;0000;0000 |
      | 0000;1010;0000;0000 | 0000;0000;0000;0000 |

  Scenario Template: trois cellules vivantes qui se touchent
    Given Grille <entrée>
    When Itération
    Then Le résultat est <sortie>

    Examples: 
      | entrée              | sortie              |
      | 0010;0010;0010;0000 | 0000;0010;0000;0000 |
      | 0000;0010;0011;0000 | 0000;0011;0011;0000 |
      | 1110;0000;0000;0000 | 0100;0000;0000;0000 |
      | 1000;0100;0010;0000 | 0000;0100;0000;0000 |
      | 0100;0010;0001;0000 | 0000;0010;0000;0000 |

  Scenario: deux cellules vivantes
    Given Grille 1000;0000;0010;0000
    When Itération
    Then Le résultat est 0000;0000;0000;0000

  Scenario: deux cellules vivantes voisines
    Given Grille 0000;0011;0000;0000
    When Itération
    Then Le résultat est 0000;0000;0000;0000

  Scenario: Pas de cellule vivante
    Given Grille 0000;0000;0000;0000
    When Itération
    Then Le résultat est 0000;0000;0000;0000

  Scenario: Une cellule vivante
    Given Grille 0000;0001;0000;0000
    When Itération
    Then Le résultat est 0000;0000;0000;0000
