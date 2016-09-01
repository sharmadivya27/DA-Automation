Narrative:
In order to assert the site is functioning barebones
As a tester
I want to run smoke tests to confirm nothing basic is broken

Meta: @skip
@server production

Scenario: Test using different page objects
Given that I am on the homepage
When I navigate to a different page
Then I should should see a different title than the homepage
