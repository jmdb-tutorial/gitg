Feature: Validation of VOD Tag URLs

  Scenario: Tag URL begins with HTTPS
    Given the tag "https://example.com/tag123" has been submitted
    When I check for the protocol of the URL
    Then I can see that the URL is HTTPS

  Scenario: Tag URL produces HTTP 200
    Given the tag "https://example.com/tag123" has been submitted
    When I attempt to access the URL
    Then I receive a HTTP response code of 200
