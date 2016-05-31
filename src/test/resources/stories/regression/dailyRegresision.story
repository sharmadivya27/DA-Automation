Basic daily regression scripts

Narrative:
In order to assert that the basic fuctionality of https://www.disasterassistance.gov/ is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: Verify all of the navbar tabs to assert that the pages open correctly
Given I am on the Disaster Assistance homepage
When I click on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly

Examples:
|navMenuItem|
|home|
|get assistance|
|information|
|about us|
|help|

Scenario: Verify all of the subtabs under the each different tab
Given I am on the Disaster Assistance homepage
When I click on the <subTab> tab under the <navMenuItem> menu item
Then the <subTab> page should open correctly

Examples:
|subTab|
|