Feature: Prueba Amazon

  Scenario Outline: Buscar un producto en amazon

    Given he user navigates to amazon
    When search for <word>
    And navigates to the second page
    And select the third item
    Then assert that the items would be available for purchase

    Examples:
      |word|
      |PlayStation|
      |Macbook|
      |Alexa|
      #|Drone|