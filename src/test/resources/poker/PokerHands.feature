Feature: Poker Hands

  # Exemples input :
  #Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
  #Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S
  #Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH
  #Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH
  #
  #Donne :
  #White wins. - with high card: Ace
  #Black wins. - with full house: 4 over 2
  #Black wins. - with high card: 9
  #Tie.
  # Carreau = K, Coeur = C, Pique = P, Trèfle = T
  # Roi = K, Dame = Q, Valet = J, 10 = D, As = A
  Scenario Template: valeur des cartes supérieure, sans figure
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu      |
      | [2K,3C,4P,6T,8T], [2C,3K,4T,6C,8C] | Egalité              |
      | [2K,3C,4P,6T,9T], [2C,3K,4T,6C,8C] | Joueur1 gagne avec 9 |
      | [2K,3C,4P,6T,8T], [2C,3K,4T,6C,7C] | Joueur1 gagne avec 8 |
      | [2K,3C,4P,6T,DT], [2C,3K,4T,6C,7C] | Joueur1 gagne avec D |
      | [2K,3C,4P,DT,6T], [2C,3K,4T,6C,7C] | Joueur1 gagne avec D |
      | [2K,3C,4P,DC,6T], [2C,3K,4T,6C,7C] | Joueur1 gagne avec D |
      | [2C,3K,4T,6C,7C], [2K,3C,4P,DC,6T] | Joueur2 gagne avec D |
      | [2C,3K,4T,6C,7C], [2K,3C,4P,DC,6T] | Joueur2 gagne avec D |
      | [2C,3K,4T,6C,7C], [2K,3C,4P,DC,6T] | Joueur2 gagne avec D |

 Scenario Template: valeur des cartes supérieure sur autre carte que la première, sans figure
   Given entrée <entree>
   Then le résultat est <resultatAttendu>

   Examples: 
     | entree                             | resultatAttendu      |
     | [2K,3C,4P,6T,8T], [2C,3K,4T,7C,8C] | Joueur2 gagne avec 7 |
     | [2K,3C,5P,7T,8T], [2C,3K,4T,7C,8C] | Joueur1 gagne avec 5 |

 Scenario Template: la paire gagne
   Given entrée <entree>
   Then le résultat est <resultatAttendu>

   Examples: 
     | entree                             | resultatAttendu                   |
     | [2K,2C,4P,6T,8T], [2P,3K,4T,6C,8C] | Joueur1 gagne avec une paire de 2 |
     | [2K,2C,4P,6T,8T], [3P,3K,4T,6C,8C] | Joueur2 gagne avec une paire de 3 |
     | [4K,4C,4P,6T,8T], [3P,3K,4T,6C,8C] | Joueur1 gagne avec une paire de 4 |

 Scenario Template: la double paire gagne
   Given entrée <entree>
   Then le résultat est <resultatAttendu>

   Examples: 
     | entree                             | resultatAttendu                          |
     | [2K,2C,5P,5T,8T], [2P,3K,4T,6C,8C] | Joueur1 gagne avec une double paire de 5 |
#
# Scenario Template: la valeur gagne avec paires égales
#   Given entrée <entree>
#   Then le résultat est <resultatAttendu>
#
#   Examples: 
#     | entree                             | resultatAttendu      |
#     | [2K,2C,4P,6T,9T], [2P,2T,4T,6C,8C] | Joueur1 gagne avec 9 |
#     | [3K,3C,4P,6T,8T], [3P,3T,4T,6C,DC] | Joueur2 gagne avec D |
#
#
# Scenario Template: deux double paires
#   Given entrée <entree>
#   Then le résultat est <resultatAttendu>
#
#   Examples: 
#     | entree                             | resultatAttendu                          |
#     | [2K,2C,5P,5T,8T], [2P,2T,4T,4C,8C] | Joueur1 gagne avec une double paire de 5 |
#     | [2K,2C,5P,5T,8T], [3P,3T,5K,5C,8C] | Joueur2 gagne avec une double paire de 5 |