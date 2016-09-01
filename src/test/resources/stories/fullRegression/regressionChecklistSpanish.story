Narrative:
In order to assert that the basic functionality of https://www.disasterassistance.gov/es/ is working
As a tester
I want to run the daily regressions at least twice a day

Meta:  

Scenario: (Spanish) Verify all of the navbar tabs to assert that the Spanish pages open correctly
Meta:     
Given I am on the Spanish Disaster Assistance homepage
When I click on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly
And there should be <numNodes> landing page nodes

Examples:
|navMenuItem|numNodes|
|inicio|0|
|obtener asistencia|9|
|información|9|
|acerca de|2|
|ayuda|5|

Scenario: (Spanish) Verify all of the quick links to assert that the Spanish pages open correctly
Meta:     
Given I am on the Spanish Disaster Assistance homepage
When I click on <quickLinkItem> within the quick links bar
Then the <quickLinkItem> page should open correctly

Examples:
|quickLinkItem|
|encontrar ayuda|
|solicitar asistencia|
|revisar estatus|
|correo electrónico|

Scenario: (Spanish) Verify the main links on homepage to assert that the Spanish pages open correctly
Meta:     
Given I am on the Spanish Disaster Assistance homepage
When I click on <mainLinksItem> within the main links bar
Then the <mainLinksItem> page should open correctly

Examples:
|mainLinksItem|
|encontrar ayuda|
|solicitar asistencia|
|revisar estatus|

Scenario: (Spanish) Verify all of the nodes on the "Get Assistance" Spanish landing page
Meta:     
Given I am on the Get Assistance Spanish landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|encuentre asistencia|
|buscar dirección|
|solicitar asistencia|
|revisar estatus|
|asistencia por categoría|
|asistencia por agencia federal|
|otra ayuda para recuperación|
|lista de verificación para aplicarse|
|formularios|

Scenario: (Spanish) Verify all of the nodes on the "Information" Spanish landing page
Meta:     
Given I am on the Information Spanish landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|canales de noticias "feeds"|
|necesidades inmediatas|
|próximo paso|
|discapacidades o necesidades funcionales y de acceso|
|adultos mayores estadounidenses|
|niños y familias|
|los recursos del desastre|
|desastres en el extranjero|
|hojas de datos|

Scenario: (Spanish) Verify all of the nodes on the "About Us" Spanish landing page
Meta:     
Given I am on the About Us Spanish landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|descripción general|
|socios|

Scenario: (Spanish) Verify all of the nodes on the "Help" Spanish landing page
Meta:     
Given I am on the Help Spanish landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|preguntas comunes|
|contáctenos|
|política de privacidad|
|accesibilidad|
|descargar plug-ins|

Scenario: (Spanish) Verify results of the questionnaire on the "Find Assistance" Spanish page
Meta:    
Given I am on the Find Assistance Spanish page
When I fully complete the questionnaire
Then I should accumulate 73 results

Scenario: (Spanish) Verify Spanish benefits results display according to use cases
Meta:     
Given I am on the Find Assistance Spanish page
When I choose only Empleo and expand all the accordions
Then I should obtain 9 results and see all the content under the accordions

Scenario: (Spanish) Verify the number of Federal Agencies and their benefits in Spanish
Meta:     
Given I am on the Assistance by Federal Agency Spanish page
When I check on each Federal Agency accordion
Then the number of benefits should match with its count

Scenario: (Spanish) Verify all the functionality of the FOA Spanish questionnaire
Meta:     
Given I am on the Find Assistance Spanish page
When I fully complete the questionnaire
And expand all the accordions
Then I should see all of the content under the accordions
When I close all of the accordions
Then none of the accordion content should be visible
And the 6 Spanish FOAs that everyone qualifies for should be visible under Additional Assistance and Resources
And the next and back buttons are displayed
When I click next
Then the 3 accordions should expand, collapse, and have content visible when open
When I click apply online
Then the DAC page should load and Captcha should be displayed

Scenario: (Spanish) Verify states in the Spanish declared disaster map are clickable
Meta:     
Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable

Scenario: (Spanish) Verify that the FEMA Twitter feed is present on the Spanish homepage
Meta:     
Given I am on the Spanish Disaster Assistance homepage
When I am viewing the FEMA Twitter feed
Then the most recent tweets should be displayed

Scenario: (Spanish) Verify Local Resources flows correctly on the Spanish homepage
Meta:     
Given I am on the Spanish Disaster Assistance homepage
When I am attempting to find local resources
Then information on resources should be visible
