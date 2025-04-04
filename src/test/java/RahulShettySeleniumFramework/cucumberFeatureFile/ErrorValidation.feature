Feature: Login page errors validation
  @Error
  Scenario Outline: Wrong user name or password error validation
    Given User land on Ecommerce website
    When User enter username <username> and password <password>
    Then User verify error "<errormessage>" message for login

    Examples: 
      | username              | password    | errormessage                 |
      | ashishpawar@gmail.lcl | @Shishpawar | Incorrect email or password. |
