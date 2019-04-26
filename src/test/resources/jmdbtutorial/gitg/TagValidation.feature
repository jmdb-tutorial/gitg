Feature: Validation of VOD Tag URLs 

<IMG SRC="https://ad.doubleclick.net/ddm/trackimp/N2121.itv.caratuk/B9996909.134320609;dc_trk_aid=306942024;dc_trk_cid=66654855;ord=[timestamp];dc_lat=;dc_rdid=;tag_for_child_directed_treatment=?" BORDER="0" HEIGHT="1" WIDTH="1" ALT="Advertisement">

  Scenario: Tag URL begins with HTTPS
  	Given the service is running
  	When the tag "https://example.com/tag123" has been submitted
    Then the response confirms the tag contains a secure URL

  #Scenario: Tag URL produces HTTP 200
    #Given the tag "https://example.com/tag123" has been submitted
    #When I attempt to access the URL
    #Then I receive a HTTP response code of 200
