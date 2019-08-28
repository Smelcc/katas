Feature: Bowling - http://codingdojo.org/kata/Bowling/

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
      | -9,--,--,--,-3,--,--,--,--,-- | 12     |
      | -9,--,--,--,23,--,--,--,--,-- | 14     |
      | 1-,--,--,--,--,--,--,--,--,-- | 1      |
      | 2-,--,--,--,--,--,--,--,--,-- | 2      |
      | 3-,--,--,--,--,--,--,--,--,-- | 3      |
      | 9-,--,--,--,--,--,--,--,--,-- | 9      |
      | --,-2,--,--,--,--,--,--,--,-- | 2      |
      | --,-2,--,--,--,--,--,1-,--,-- | 3      |
      | -/,--,--,--,--,--,--,--,--,-- | 10     |
      | 3/,--,--,--,--,--,--,--,--,-- | 10     |
      | X,--,--,--,--,--,--,--,--,--  | 10     |
      | --,-2,--,--,--,--,--,1/,--,-- | 12     |
      | --,-1,--,--,--,--,--,1/,--,-- | 11     |
      | --,1-,--,--,--,--,--,1/,--,-- | 11     |
      | --,--,--,--,--,--,1/,--,2-,-- | 12     |
      | --,--,--,--,--,--,1/,--,3-,-- | 13     |
      | --,--,--,--,--,--,1/,--,5-,-- | 15     |
      | --,--,--,7-,--,--,1/,--,5-,-- | 22     |
      | --,--,--,5-,--,--,1/,--,5-,-- | 20     |
      | --,--,--,5/,--,--,1/,--,5-,-- | 25     |
      | --,-/,--,5/,--,--,1/,--,5-,-- | 35     |
      | -/,-/,--,5/,--,--,1/,--,5-,-- | 45     |
      | -/,1-,--,--,--,--,--,--,--,-- | 12     |
      | -/,2-,--,--,--,--,--,--,--,-- | 14     |
      | -/,8-,--,--,--,--,--,--,--,-- | 26     |
      | -/,8-,2-,--,--,--,--,--,--,-- | 28     |
      | -/,8/,2-,--,--,--,--,--,--,-- | 32     |
      | -/,8/,3-,--,--,--,--,--,--,-- | 34     |
      | -/,8/,3/,2-,--,--,--,--,--,-- | 45     |
      | -/,8/,-/,2-,--,--,--,--,--,-- | 42     |
      | --,X,--,--,--,--,--,--,--,--  | 10     |
      | --,X,4-,--,--,--,--,--,--,--  | 18     |
      | --,X,42,--,--,--,--,--,--,--  | 22     |
      | --,X,4/,--,--,--,--,--,--,--  | 30     |
      | --,X,-/,--,--,--,--,--,--,--  | 30     |
      | --,X,1/,--,--,--,--,--,--,--  | 30     |
      | --,X,1/,4-,--,--,--,--,--,--  | 38     |
      | --,X,1/,5-,--,--,--,--,--,--  | 40     |
      | --,X,X,X,--,--,--,--,--,--    | 60     |
