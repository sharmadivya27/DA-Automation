Basic daily regression scripts for Spanish site

Narrative:
In order to assert that the basic functionality of https://www.disasterassistance.gov/es/ is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: Verify all of the navbar tabs to assert that the Spanish pages open correctly
Meta:

Given I am on the spanish Disaster Assistance homepage
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