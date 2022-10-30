Feature: Toogle Language

  Scenario Outline: User wants to make sure the correct language
    Given User opened browser
    When User opened website
    And User wants to verify the toogle language
    And User wants to switch toogle <language>
    Then User wants to verify correct <languages>
    Examples:
    | language | languages |
    | id       | id        |
    | en       | en        |
