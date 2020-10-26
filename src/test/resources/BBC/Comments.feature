Feature: Comments Feature
#User story: A user once logged in navigates through the BBC Home page www.bbc.co.uk for a Top News Headline and
# checks if the comments can be viewed for the article.
#  As a registered user
#  I want to send a comment on a news
#  So that editor and others can see my views


  @WithoutSignIN
  Scenario: User should not be able to write any comment without login In.
    Given Open BBC website
    When Go to News Headlines from Home Page
    And Go on the article where commenting is enabled
    Then Sign in and Register button should be visible
    And User should be able to view comments

  @WithSignIN
  Scenario Outline: User can view & write comments once logged in.
    Given Open BBC website
    And Go to SignIn tab on the top navigation bar
    When Enter valid "<Username>" and "<Password>" and click on Sign In button
    Then It should navigate to BBC Home Page
    When Go to News Headlines from Home Page
    And Go on the article where commenting is enabled
    Then User should be able to view comments
    And User should be able to add a comment

    Examples:
      | Username                             | Password         |
      | c2F0ZXNoY2hhdWRoYXJpMDFAZ21haWwuY29t | U21hcnRAMTIzNA== |


