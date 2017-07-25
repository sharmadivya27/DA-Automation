Narrative:
In order to assure that the basic functionality of disasterassistance.gov is working
As a tester
I want to run the daily regressions at least twice a day

Meta: 

Scenario: Verify all of the navbar tabs to assert that the pages open correctly
Meta: 
@category daily 

Given I am on the Disaster Assistance homepage
When I click on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly
And there should be <numNodes> landing page nodes

Examples:
|navMenuItem|numNodes|
|home|0|    
|get assistance|10|
|information|9|
|about us|2|
|help|5|

Scenario: Verify all of the quick links to assert that the pages open correctly
Meta:    
@category daily   

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
Meta:   
@category daily 
@tag mobile

Given I am on the Disaster Assistance homepage
When I click on <mainLinksItem> within the main links bar
Then the <mainLinksItem> page should open correctly

Examples:
|mainLinksItem|
|find assistance|
|apply online|
|check status|

Scenario: Verify all the menu links on the "Get Assistance" tab
Meta: 
@category new
@tag mobile

Given I am on the Disaster Assistance homepage
When I click on the <menuLinks> in the Get Assistance tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|address look-up|
|find assistance|
|apply online|
|check your status|
|assistance by category|
|assistance by federal agency|
|community leaders|
|other recovery help|
|application checklist| 
|forms|

Scenario: Verify all of the nodes on the "Get Assistance" landing page
Meta:  
@category daily 
                   
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
|community leaders|
|other recovery help|
|application checklist|
|forms|

Scenario: Verify all the menu links on the "Information" tab
Meta:   
@category new
@tag mobile

Given I am on the Disaster Assistance homepage
When I click on the <menuLinks> in the Information tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|news feeds|
|immediate needs| 
|moving forward|
|disabilities or access and functional needs|
|older americans|
|children and families|
|disaster types|
|foreign disasters|
|fact sheets|

Scenario: Verify all of the nodes on the "Information" landing page
Meta:  
@category daily 
                              
Given I am on the Information landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly 

Examples:
|landingPageNode|
|news feeds|
|immediate needs|
|moving forward|
|disabilities or access and functional needs|
|older americans|
|children and families|
|disaster types|
|foreign disasters|
|fact sheets|

Scenario: Verify the More/Less button is on each of the landing page nodes under the "Information" landing page
Meta:  
@category new 
@tag mobile 

Given I am on the Information landing page
When I click on the <landingPageNode> landing page node
Then I click on the more button and content should appear under the title of the <landingPageNode>

Examples:
|landingPageNode|
|immediate needs|
|moving forward|
|disabilities or access and functional needs|
|older americans|
|children and families|
|disaster types|

Scenario: Verify all of the titles on the "News Feeds" landing page node
Meta:  
@category new 
@tag mobile-works

When I am on the News Feeds landing page node
Then all of the sub-titles should show on the page

Scenario: Verify all of the titles on the "Immediate Needs" landing page node 
Meta:   
@category new
@tag mobile

Given I am on the Immediate Needs landing page node
When I click on the link under each <subTitle> on the Immediate Needs page
Then the link under the <subTitle> should open

Examples:
|subTitle|
|Evacuate|
|Stay Put and Shelter in Place|
|Finding Lost Family and Friends|
|Finding and Caring for Pets|
|Find a Safe Place to Go|

Scenario: Verify all the menu links on the "About Us" tab
Meta: 
@category new
@tag mobile

Given I am on the Disaster Assistance homepage
When I click on the <menuLinks> in the About Us tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|overview|
|partners|

Scenario: Verify all of the nodes on the "About Us" landing page
Meta:  
@category daily 
                              
Given I am on the About Us landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|overview|
|partners|

Scenario: Verify all the menu links on the "Help" tab
Meta:  
@category new
@tag mobile

Given I am on the Disaster Assistance homepage 
When I click on the <menuLinks> in the Help tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|faqs|
|contact us|
|privacy policy|
|accessibility|
|download plug-ins|

Scenario: Verify all of the nodes on the "Help" landing page
Meta:  
@category daily
                    
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
Meta:  
@category daily
@tag mobile
                 
Given I am on the Find Assistance page
When I choose only Employment and expand all the accordions
Then I should obtain 9 results and see all the content under the accordions

Scenario: Verify the number of Federal Agencies and their benefits
Meta:  
@category daily 
@tag mobile-works 
                                 
Given I am on the Assistance by Federal Agency page
When I check on each Federal Agency accordion
Then the number of benefits should match with its count

Scenario: Verify all the functionality of the FOA questionnaire
Meta:  
@category daily 
@tag mobile 

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
Meta: 
@category daily 
                        
Given I am on the Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable

Scenario: Dynamically verify results of the questionnaire on the "Find Assistance" page 
Meta:         
@category daily 
@tag mobile
          
Given I am on the Find Assistance page
When I fully complete the questionnaire
Then I should accumulate the same number of results as the text on the Get Results button 

Scenario: Verify that the FEMA Twitter feed is present on the homepage
Meta:          
@category daily 
@tag mobile-works
               
Given I am on the Disaster Assistance homepage
When I am viewing the FEMA Twitter feed
Then the most recent tweets should be displayed

Scenario: Verify Local Resources flows correctly
Meta:  
@category daily 
@tag mobile-works 

Given I am on the Disaster Assistance homepage
When I am attempting to find local resources
Then information on resources should be visible

Scenario: Verify the search results on the Community Leaders page
Meta: 
@category daily 

Given I am on the Community Leaders page on Disaster Assistance
When I type those tag words into the Community Leaders search field for the <siteName>
Then I should see that page in the search results 

Examples:
|siteName|
|Grants|
|Fema|

Scenario: Verify the pages under each site name 
Meta:
@category daily 

Given I am on the drupal DA homepage
When I log into drupal with username and password
Then I click on the Manage Pages tab to pick a <siteName> and click on Get pages
Then the url for the <siteName> should be displayed 

Examples:
|siteName|
|DisasterAssistance| 
|Benefits|
|Ready|
|NRN|
|Grants|
|USA.gov|
|Fema|
|CFDA|
|DHS|
|Redcross|
|HHS|
|SBA|
|FCC|
|HUD|
|EPA|
|Energy|
|CDC|

Scenario: Verify the results of the quick search items 
Meta: 
@category daily 

Given I am on the Community Leaders page on Disaster Assistance
When I type the search words into the Community Leaders search field for the <quickSearch> item 
Then the results should include those search words

Examples:
|quickSearch|
|Community Preparedness|
|Disaster Recovery Resources|
|Emergency Shelter and Housing|
|How Can You Help?|
|Infrastructure, Utilities, and Other Public Assistance|

Scenario: Verify the declared states on the declared disaster map 
Meta: 
@category daily 

Given I am on the Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable
Then I should be able to view the list of the declared states

Scenario: Verify the declared counties on the declared disaster map 
Meta: 
@category daily  

Given I am on the Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable
Then I should be able to view the list of the declared counties