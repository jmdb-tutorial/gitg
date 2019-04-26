Feature: Validation of VOD Tag URLs 

  Scenario: Tag URL begins with HTTPS
  	Given the service is running
  	When the tag "https://ad.doubleclick.net/ddm/trackimp/" has been submitted
    Then the response confirms the tag contains a secure URL
    
  Scenario: Tag URL begins with HTTP
  	Given the service is running
  	When the tag "http://ad.doubleclick.net/ddm/trackimp/" has been submitted
    Then the response confirms the tag contains an unsecure URL

  #Scenario: Tag URL produces HTTP 200
    #Given the tag "https://example.com/tag123" has been submitted
    #When I attempt to access the URL
    #Then I receive a HTTP response code of 200
