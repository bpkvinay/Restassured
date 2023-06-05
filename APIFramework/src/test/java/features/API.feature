


Feature: Validating API scenarios

Scenario Outline: Validate the lead created succesfully using CreatLeadAPI

Given Add LeadAPI Payload with "<first_name>" "<phone_mobile>" "<lastname>" "<loan_amount_c>" "<is_renewal>"
When user calls "AddLeadAPI" with "POST" http request
Then the API call got success with status code 200
And "Success" in response body is "true"
And "Message" in response body is "Lead Created Successfully"


Examples: 
|first_name|lastname|phone_mobile|loan_amount_c|is_renewal|
|bang      |ah      |1003881371  |600000    |0         |

