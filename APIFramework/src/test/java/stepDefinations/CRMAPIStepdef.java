package stepDefinations;




import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APITestDataBuilder;
import resources.Utils;

public class CRMAPIStepdef extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	APITestDataBuilder testdata=new APITestDataBuilder();
    
	 

	@Given("^Add LeadAPI Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_leadapi_payload_with(String firstname, String phonemobile, String lastname, String loanamountc, String isrenewal ) throws Throwable {
      res=given().spec(requestspecifications()).body(testdata.AddLeadPayload(firstname, lastname, phonemobile, isrenewal, loanamountc));
    }

    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String strArg1, String strArg2) throws Throwable {
    	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	response=res.when().post(readConfig("baseUrl"));
    }

    @Then("^the API call got success with status code 200$")
    public void the_api_call_got_success_with_status_code_200() throws Throwable {
    	assertEquals(response.getStatusCode(),200);
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String keyValue, String Expectedvalue) throws Throwable {
    	assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}

    }

