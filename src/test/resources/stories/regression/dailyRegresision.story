Basic daily regression scripts

Narrative:
In order to assert that the basic fuctionality of https://www.disasterassistance.gov/ is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: Verify all of the navbar tabs to assert that the pages open correctly
Meta:
@skip
Given I am on the Disaster Assistance homepage
When I click on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly
And there should be <numNodes> landing page nodes

Examples:
|navMenuItem|numNodes|
|home|0|
|get assistance|8|
|information|10|
|about us|2|
|help|5|

Scenario: Verify all of the subtabs under the each different tab
Given I am on the Disaster Assistance homepage
When I click on the <subTab> tab under the <navMenuItem> menu item
Then the <subTab> page should open correctly