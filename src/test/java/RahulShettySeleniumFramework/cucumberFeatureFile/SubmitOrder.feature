Feature: Purchase order from Ecommerce website

  Background: 
    Given User land on Ecommerce website

  Scenario Outline: Submit the order from product list
    Given User enter username <username> and password <password>
    When User search and add product <product> in cart
    And User click on cart button
    Then User land on cart page and verify added product <product>
    When User click on checkout button
    And User land on checkout page and fill all the details <cardNumber>, <cvv>, <cardName>, <country> of checkout page
    And user click on place order button
    Then User land on order details page and verify order detail text message "<message>"

    Examples: 
      | username               | password     | product         | cardNumber          | cvv  | cardName     | country | message                 |
      | ashishpawar1@gmail.lcl | @Shishpawar1 | ADIDAS ORIGINAL | 2222 3333 4444 5555 | 1234 | Ashish Pawar | India   | Thankyou for the order. |
      | ashishpawar1@gmail.lcl | @Shishpawar1 | ZARA COAT 3     | 2222 3333 4444 5555 | 1234 | Ashish Pawar | India   | Thankyou for the order. |
