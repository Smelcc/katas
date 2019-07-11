Feature: Bowling

  Scenario Template: Calculer le score final après 10 coups lambda
    Given Score <entrée>
    When jouer partie
    Then Le résultat est <sortie>

    Examples: 
      | entrée                        | sortie |
      | --,--,--,--,--,--,--,--,--,-- | 0      |
      | -1,--,--,--,--,--,--,--,--,-- | 1      |
      | -2,--,--,--,--,--,--,--,--,-- | 2      |
      | -3,--,--,--,--,--,--,--,--,-- | 3      |
      | -4,--,--,--,--,--,--,--,--,-- | 4      |
      | -5,--,--,--,--,--,--,--,--,-- | 5      |
      | -6,--,--,--,--,--,--,--,--,-- | 6      |
      | -7,--,--,--,--,--,--,--,--,-- | 7      |
      | -8,--,--,--,--,--,--,--,--,-- | 8      |
      | -9,--,--,--,--,--,--,--,--,-- | 9      |
      | 1-,--,--,--,--,--,--,--,--,-- | 1      |
      | 2-,--,--,--,--,--,--,--,--,-- | 2      |
      | 3-,--,--,--,--,--,--,--,--,-- | 3      |
      | 9-,--,--,--,--,--,--,--,--,-- | 9      |
      | --,-2,--,--,--,--,--,--,--,-- | 2      |
      | --,-2,--,--,--,--,--,1-,--,-- | 3      |
      | --,-2,--,--,--,--,--,1/,--,-- | 12     |
      | --,-1,--,--,--,--,--,1/,--,-- | 11     |
      | --,1-,--,--,--,--,--,1/,--,-- | 11     |
      | --,--,--,--,--,--,1/,--,2-,-- | 12     |
