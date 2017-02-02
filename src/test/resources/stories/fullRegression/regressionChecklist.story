Narrative:
In order to assure that the basic functionality of disasterassistance.gov is working
As a tester
I want to run the daily regressions at least twice a day

Meta:

Scenario: Verify all of the navbar tabs to assert that the pages open correctly
Meta: @skip                            
Given I am on the Disaster Assistance homepage
When I click on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly
And there should be <numNodes> landing page nodes

Examples:
|navMenuItem|numNodes|
|home|0|
|get assistance|9|
|information|8|
|about us|2|
|help|5|

Scenario: Verify all of the quick links to assert that the pages open correctly
Meta: @skip                      
Given I am on the Disaster Assistance homepage
When I click on <quickLinkItem> within the quick links bar
Then the <quickLinkItem> page should open correctly

Examples:
|quickLinkItem|
|find assistance|
|apply online|
|check your status|
|email|

Scenario: Verify the main links on homepage to assert that the pages open correctly
Meta: @skip                       
Given I am on the Disaster Assistance homepage
When I click on <mainLinksItem> within the main links bar
Then the <mainLinksItem> page should open correctly

Examples:
|mainLinksItem|
|find assistance|
|apply online|
|check status|

Scenario: Verify all of the nodes on the "Get Assistance" landing page
Meta: @skip                    
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
|other recovery help|
|application checklist|
|forms|

Scenario: Verify all of the nodes on the "Information" landing page
Meta: @skip                               
Given I am on the Information landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|immediate needs|
|moving forward|
|disabilities or access and functional needs|
|older americans|
|children and families|
|disaster types|
|foreign disasters|
|fact sheets|

Scenario: Verify all of the nodes on the "About Us" landing page
Meta: @skip                               
Given I am on the About Us landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|overview|
|partners|

Scenario: Verify all of the nodes on the "Help" landing page
Meta: @skip                      
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

Scenario: Verify benefits results display according to use cases
Meta: @skip                   
Given I am on the Find Assistance page
When I choose only Employment and expand all the accordions
Then I should obtain 9 results and see all the content under the accordions

Scenario: Verify the number of Federal Agencies and their benefits
Meta: @skip                               
Given I am on the Assistance by Federal Agency page
When I check on each Federal Agency accordion
Then the number of benefits should match with its count

Scenario: Verify all the functionality of the FOA questionnaire
Meta: @skip                
Given I am on the Find Assistance page
When I fully complete the questionnaire
Then I should expand all the accordions to see all of the content under the accordions
When I close all of the accordions
Then none of the accordion content should be visible
And the 6 FOAs that everyone qualifies for should be visible under Additional Assistance and Resources
And the next and back buttons are displayed
When I click next
Then the 3 accordions should expand, collapse, and have content visible when open
When I click apply online
Then the DAC page should load

Scenario: Verify states in the declared disaster map are clickable
Meta: @skip                              
Given I am on the Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable

Scenario: Dynamically verify results of the questionnaire on the "Find Assistance" page 
Meta: @skip                   
Given I am on the Find Assistance page
When I fully complete the questionnaire
Then I should accumulate the same number of results as the text on the Get Results button 

Scenario: Verify that the FEMA Twitter feed is present on the homepage
Meta: @skip                              
Given I am on the Disaster Assistance homepage
When I am viewing the FEMA Twitter feed
Then the most recent tweets should be displayed

Scenario: Verify Local Resources flows correctly
Meta:
Given I am on the Disaster Assistance homepage
When I am attempting to find local resources
Then information on resources should be visible
