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

Scenario: Verify all of the nodes on the "Get Assistance" landing page
Meta:
@skip
Given I am on the Get Assistance landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|address look-up|
|find assistance|
|apply online|
|check your status|
|assistance by category|
|assistance by federal agency|
|application checklist|
|forms|

Scenario: Verify all of the nodes on the "Information" landing page
Meta:
@skip
Given I am on the Information landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|news feeds|
|immediate needs|
|moving forward|
|community resources|
|disabilities or access and functional needs|
|older americans|
|children and families|
|disaster types|
|foreign disasters|
|fact sheets|

Scenario: Verify all of the nodes on the "About Us" landing page
Meta:
@skip
Given I am on the About Us landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|overview|
|partners|

Scenario: Verify all of the nodes on the "Help" landing page
Meta:
@skip
Given I am on the Help landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|faqs|
|contact us|
|privacy policy|
|accessibility|
|download plug-ins|

Scenario: Verify results of the questionnaire on the "Find Assistance" page
Meta:
@skip
Given I am on the Find Assistance page
When I answer 'Yes' on all questions
Then I should accumulate 73 results

Scenario: Verify benefits results display according to use cases
Meta:
@skip
Given I am on the Find Assistance page
When I choose only Employment
Then I should obtain 9 results

Scenario: Verify the number of Federal Agencies and their benefits
Meta:
@skip
Given I am on the Assistance by Federal Agency page
When I check on each Federal Agency accordion
Then the number of benefits should match with its count

Scenario: Verify states in the declared disaster map are clickable
Meta:
@skip
Given I am on the Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable

Scenario: Verify that the FEMA Twitter feed is present on the homepage
Meta:
@skip
Given I am on the Disaster Assistance homepage
When I am viewing the FEMA Twitter feed
Then the most recent tweets should be displayed

Scenario: Verify Local Resources flows correctly
Meta:
@skip
Given I am on the Disaster Assistance homepage
When I am attempting to find local resources
Then information on resources should be visible

