Basic daily regression scripts

Narrative:
In order to assert that the basic fuctionality of https://www.disasterassistance.gov/ is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: Verify all of the navbar tabs to assert that the pages open correctly
Given I am on the Disaster Assistance homepage
When I click on each link in the top navigation bar
Then the <navTab> page should open correctly

Examples:
|navTab|
|home|
|get assitance|
|information|
|about us|
|help|