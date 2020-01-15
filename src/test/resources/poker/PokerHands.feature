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
  
  # Ordre des combinaisons : hauteur, paire, double paire, brelan, suite, couleur, full, carré, quinte flush, quinte flush royale
  
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
      | [2K,3C,4P,6T,8T], [2C,3K,4T,7C,8C] | Joueur2 gagne avec 8 |
      | [2K,3C,5P,7T,8T], [2C,3K,4T,7C,8C] | Joueur1 gagne avec 8 |

  Scenario Template: la paire gagne
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                   |
      | [2K,2C,4P,6T,8T], [2P,3K,4T,6C,8C] | Joueur1 gagne avec une paire de 2 |
      | [2K,2C,4P,6T,8T], [3P,3K,4T,6C,8C] | Joueur2 gagne avec une paire de 3 |
      | [4K,4C,2P,6T,8T], [3P,3K,4T,6C,8C] | Joueur1 gagne avec une paire de 4 |

  Scenario Template: la double paire gagne
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                          |
      | [2K,2C,5P,5T,8T], [2P,3K,4T,6C,8C] | Joueur1 gagne avec une double paire de 5 |

  Scenario Template: la valeur gagne avec paires égales
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                   |
      | [2K,2C,4P,6T,9T], [2P,2T,4T,6C,8C] | Joueur1 gagne avec une paire de 2 |
      | [3K,3C,4P,6T,8T], [3P,3T,4T,6C,DC] | Joueur2 gagne avec une paire de 3 |
      | [3K,3C,4P,6T,8T], [3P,3T,4T,6C,8C] | Egalité                           |

  Scenario Template: deux double paires
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                          |
      | [2K,2C,5P,5T,8T], [2P,2T,4T,4C,8C] | Joueur1 gagne avec une double paire de 5 |
      | [2K,2C,5P,5T,8T], [3P,3T,5K,5C,8C] | Joueur2 gagne avec une double paire de 5 |
      | [2K,2C,5P,5T,8T], [2P,2T,5K,5C,8C] | Egalité                                  |
      | [2K,2C,5P,5T,9T], [2P,2T,5K,5C,8C] | Joueur1 gagne avec une double paire de 5 |

  Scenario Template: brelan
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                   |
      | [AK,AC,AP,2T,3T], [2P,2T,4T,4C,8C] | Joueur1 gagne avec un brelan de A |
      | [AK,AC,AP,2T,3T], [KP,KT,KT,4C,8C] | Joueur1 gagne avec un brelan de A |
      | [KK,KC,KP,2T,3T], [AP,AT,AT,4C,8C] | Joueur2 gagne avec un brelan de A |

  Scenario Template: full
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                       |
      | [KK,KC,KP,2C,2T], [AP,AC,AT,4C,8C] | Joueur1 gagne avec un full de K par 2 |
      | [KK,KC,KP,2C,2T], [AP,AC,AT,8T,8C] | Joueur2 gagne avec un full de A par 8 |

  Scenario Template: suite
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                   |
      | [2K,3C,4P,5C,6T], [AP,AC,AT,4C,8C] | Joueur1 gagne avec une suite au 6 |
      | [2K,3C,4P,5C,AT], [AP,KC,QT,JC,DC] | Joueur2 gagne avec une suite au A |
      | [2K,3C,4P,5C,AT], [AP,KC,JT,JC,DC] | Joueur1 gagne avec une suite au 5 |

  Scenario Template: carré
    Given entrée <entree>
    Then le résultat est <resultatAttendu>

    Examples: 
      | entree                             | resultatAttendu                  |
      | [2K,2C,2P,5C,2T], [AP,AC,AT,4C,8C] | Joueur1 gagne avec un carré de 2 |
