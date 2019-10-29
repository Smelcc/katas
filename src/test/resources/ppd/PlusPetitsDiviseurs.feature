Feature: Plus Petits Diviseurs Communs

  Scenario Template: Trouve la liste des plus petits diviseurs d'un nombre entier passé en variable d'interface
    Given nombre <nombre>
    Then la liste attendue est <liste>

    Examples: 
      | nombre  | liste                   |
      | 1       |                         |
      | 2       | 2                       |
      | 3       | 3                       |
      | 4       | 2 2                     |
      | 8       | 2 2 2                   |
      | 6       | 2 3                     |
      | 9       | 3 3                     |
      | 27      | 3 3 3                   |
      | 81      | 3 3 3 3                 |
      | 5       | 5                       |
      | 25      | 5 5                     |
      | 18      | 2 3 3                   |
      | 12      | 2 2 3                   |
      | 7       | 7                       |
      | 14      | 2 7                     |
      | 1000000 | 2 2 2 2 2 2 5 5 5 5 5 5 |
      | 221     | 13 17                   |
