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


