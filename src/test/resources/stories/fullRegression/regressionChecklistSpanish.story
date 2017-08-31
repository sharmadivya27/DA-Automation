Narrative:
In order to assert that the basic functionality of https://www.disasterassistance.gov/es/ is working
As a tester
I want to run the daily regressions at least twice a day

Meta:

Scenario: (Spanish) Verify all of the navbar tabs to assert that the Spanish pages open correctly
Meta:
@category daily 
                         
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
@category daily 
                   
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
@category daily 
                          
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

Scenario: (Spanish) Verify all the menu links on the "Get Assistance" tab on mobile
Meta:
@tag mobile-works

Given I am on the Spanish Disaster Assistance mobile page
When I click on the <menuLinks> in the Get Assistance tab on mobile in spanish
Then the <menuLinks> page should open correctly

Examples:
|menuLinks|
|buscar dirección|
|encuentre asistencia|
|asistencia por categoría|
|asistencia por agencia federal|
|otra ayuda para recuperación|
|líderes comunitarios| 
|lista de verificación para aplicarse|
|formularios|

Scenario: (Spanish) Verify all of the nodes on the "Get Assistance" Spanish landing page
Meta:  
@category daily 
                    
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

Scenario: (Spanish) Verify all of the nodes on the "Information" Spanish landing page
Meta:    
@category daily 
                          
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

Scenario: (Spanish) Verify all the menu links on the "Information" tab on mobile
Meta:
@tag mobile-works

Given I am on the Spanish Disaster Assistance mobile page
When I click on the <menuLinks> in the Information tab on mobile in spanish
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

Scenario: (Spanish) Verify all of the titles on the Spanish "News Feeds" landing page node
Meta:
@category new 

Given I am on the Information Spanish landing page
When I click on the <landingPageNode> landing page node
Then all of the Spanish sub-titles should show on the page

Examples:
|landingPageNode|
|canales de noticias "feeds"| 

Scenario: (Spanish) Verify all of the titles on the "News Feeds" landing page node on mobile
Meta:
@category new 
@tag mobile-works

Given I am on the Spanish Disaster Assistance mobile page
When I am on the News Feeds landing page node
Then all of the sub-titles should show on the page

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

Scenario: (Spanish) Verify all the menu links on the "About Us" tab on mobile
Meta:
@tag mobile-works

Given I am on the Spanish Disaster Assistance mobile page
When I click on the <menuLinks> in the About Us tab on mobile in spanish
Then the <menuLinks> page should open correctly

Examples:
|menuLinks|
|descripción general|
|socios|

Scenario: (Spanish) Verify all of the nodes on the "About Us" Spanish landing page
Meta:
@category daily 
                               
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

Scenario: (Spanish) Verify all the menu links on the "Help" tab on mobile
Meta:
@tag mobile-works

Given I am on the Spanish Disaster Assistance mobile page
When I click on the <menuLinks> in the Help tab on mobile in spanish 
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
@category daily
                              
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
@category daily
                    
Given I am on the Find Assistance Spanish page
When I choose only Empleo and expand all the accordions
Then I should obtain 9 results and see all the content under the accordions

Scenario: (Spanish) Verify the Apply Online mobile flag on mobile
Meta:
@tag mobile-works

Given I am on the Spanish Disaster Assistance mobile page   
When I click on apply online quick search item on mobile
Then the DAC page should load on mobile

Scenario: (Spanish) Verify the number of Federal Agencies and their benefits in Spanish
Meta:     
@category daily 
                      
Given I am on the Assistance by Federal Agency Spanish page
When I check on each Federal Agency accordion
Then the number of benefits should match with its count

Scenario: Verify the number of Federal Agencies and their benefits in Spanish on mobile
Meta:
@tag mobile-works 
                            
Given I am on the Spanish Disaster Assistance mobile page     
Given I am on the Assistance by Federal Agency Spanish page
When I check on each Federal Agency accordion
Then the number of benefits should match with its count

Scenario: (Spanish) Verify all the functionality of the FOA Spanish questionnaire
Meta:
@category daily 
               
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
@category daily 
                               
Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable

Scenario: (Spanish) Dynamically verify results of the questionnaire on the "Find Assistance" page 
Meta:
@category daily 
  
Given I am on the Find Assistance Spanish page
When I fully complete the questionnaire
Then I should accumulate the same number of results as the text on the Get Results button 

Scenario: (Spanish) Verify that the FEMA Twitter feed is present on the Spanish homepage
Meta:  
@category daily 
                             
Given I am on the Spanish Disaster Assistance homepage
When I am viewing the FEMA Twitter feed
Then the most recent tweets should be displayed

Scenario: (Spanish) Verify that the FEMA Twitter feed is present on the homepage on mobile
Meta:
@tag mobile-works 
               
Given I am on the Spanish Disaster Assistance mobile page
Given I am on the Spanish Disaster Assistance homepage
When I am viewing the FEMA Twitter feed
Then the most recent tweets should be displayed

Scenario: (Spanish) Verify Local Resources flows correctly on the Spanish homepage
Meta:   
@category daily 
                            
Given I am on the Spanish Disaster Assistance homepage
When I am attempting to find local resources
Then information on resources should be visible

Scenario: (Spanish) Verify Local Resources flows correctly on mobile
Meta:
@tag mobile-works 

Given I am on the Spanish Disaster Assistance mobile page
Given I am on the Spanish Disaster Assistance homepage
When I am attempting to find local resources
Then information on resources should be visible

Scenario: (Spanish) Verify the declared states on the declared disaster map 
Meta:
@category daily 

Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable
Then I should be able to view the list of the declared states in Spanish

Scenario: (Spanish) Verify the declared counties on the declared disaster map 
Meta:
@category daily 

Given I am on the Spanish Disaster Assistance homepage
When I am viewing the declared disaster map
Then states with disasters should be clickable
Then I should be able to view the list of the declared counties in Spanish

Scenario: (Spanish) Verify the results of the quick search items 
Meta:
@category NWD 

Given I am on the spanish Community Leaders page on Disaster Assistance
When I type the search words into the Community Leaders search field for the <quickSearch> item 
Then the results should include those search words

Examples:
|quickSearch|
|Infraestructura, servicios públicos y otra asistencia pública|
|Preparación para la comunidad|
|Recursos para recuperación de desastre|
|Viviendas y refugios de emergencia|
|¿Como puede ayudar?|