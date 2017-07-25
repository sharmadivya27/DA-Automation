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
|obtener asistencia|10| 
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

Scenario: (Spanish) Verify all the menu links on the Spanish "Get Assistance" tab
Meta: 
@category new

Given I am on the Spanish Disaster Assistance homepage
When I click on the <menuLinks> in the Spanish Get Assistance tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|buscar dirección|
|encuentre asistencia|
|solicitar asistencia|
|revisar estatus|
|asistencia por categoría|
|asistencia por agencia federal|
|otra ayuda para recuperación|
|líderes comunitarios|
|lista de verificación para aplicarse|
|formularios|

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

Scenario: (Spanish) Verify all the menu links on the Spanish "Information" tab
Meta:  
@category new

Given I am on the Spanish Disaster Assistance homepage
When I click on the <menuLinks> in the Spanish Information tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|canales de noticias|
|necesidades inmediatas|
|próximo paso|
|discapacidades o necesidades funcionales y de acceso|
|adultos mayores estadounidenses|
|niños y familias|
|los recursos del desastre|
|desastres en el extranjero|
|hojas de datos|

Scenario: (Spanish) Verify the More/Less button is on each of the landing page nodes under the Spanish "Information" landing page
Meta:   
@category new 

Given I am on the Information Spanish landing page
When I click on the <landingPageNode> landing page node
Then I click on the more button and content should appear under the title of the <landingPageNode>

Examples:
|landingPageNode|
|necesidades inmediatas|
|próximo paso|
|discapacidades o necesidades funcionales y de acceso|
|adultos mayores estadounidenses|
|niños y familias|

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

Scenario: (Spanish) Verify all of the titles on the Spanish "News Feeds" landing page node
Meta:   
@category new 

Given I am on the Information Spanish landing page
When I click on the <landingPageNode> landing page node
Then all of the Spanish sub-titles should show on the page

Examples:
|landingPageNode|
|canales de noticias "feeds"| 

Scenario: (Spanish) Verify all of the titles on the Spanish "Immediate Needs" landing page node 
Meta:    
@category new

Given I am on the Immediate Needs Spanish landing page node
When I click on the link under each <subTitle> on the Immediate Needs Spanish page
Then the link under the <subTitle> should open

Examples:
|subTitle|
|Evacuación|
|Permanezca Donde Está y Refúgiese|
|Búsqueda de familiares y amigos perdidos|
|Búsqueda y cuidado de mascotas|
|Busque un Lugar Seguro Donde Ir|

Scenario: (Spanish) Verify all the menu links on the Spanish "About Us" tab
Meta:   
@category new

Given I am on the Spanish Disaster Assistance homepage
When I click on the <menuLinks> in the Spanish About Us tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|descripción general|
|socios|

Scenario: (Spanish) Verify all of the nodes on the "About Us" Spanish landing page
Meta:                                 
Given I am on the About Us Spanish landing page
When I click on the <landingPageNode> landing page node
Then the <landingPageNode> page should open correctly

Examples:
|landingPageNode|
|descripción general|
|socios|

Scenario: (Spanish) Verify all the menu links on the Spanish "Help" tab
Meta:  
@category new

Given I am on the Spanish Disaster Assistance homepage
When I click on the <menuLinks> in the Spanish Help tab
Then the <menuLinks> page should open correctly 

Examples:
|menuLinks|
|preguntas comunes|
|contáctenos|
|política de privacidad|
|accesibilidad|
|descargar plug-ins|

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
Then I should expand all the accordions to see all of the content under the accordions
When I close all of the accordions
Then none of the accordion content should be visible
And the 6 Spanish FOAs that everyone qualifies for should be visible under Additional Assistance and Resources
And the next and back buttons are displayed
When I click next
Then the 3 accordions should expand, collapse, and have content visible when open
When I click apply online
Then the DAC page should load

Scenario: (Spanish) Verify states in the Spanish declared disaster map are clickable
Meta:                                
Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable

Scenario: (Spanish) Dynamically verify results of the questionnaire on the "Find Assistance" page 
Meta:      
Given I am on the Find Assistance Spanish page
When I fully complete the questionnaire
Then I should accumulate the same number of results as the text on the Get Results button 

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

Scenario: (Spanish) Verify the declared states on the declared disaster map 
Meta:  

Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable
Then I should be able to view the list of the declared states in Spanish

Scenario: (Spanish) Verify the declared counties on the declared disaster map 
Meta: 

Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable
Then I should be able to view the list of the declared counties in Spanish
