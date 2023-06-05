package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	/**
	 * @author Vinay.Gaonkar
	 * @return
	 */
	public static RequestSpecification Requestspec;
	
	     
	
								
		/**
	    * This method is used to log as well as to hit the url and contenttype JSON
		* @return
		* @throws IOException 
	    */
		public RequestSpecification requestspecifications() throws IOException {
			
			if (Requestspec==null) {
			PrintStream Log= new PrintStream(new FileOutputStream("log.text"));
			Requestspec = new RequestSpecBuilder().setBaseUri(readConfig("baseUrl"))
		              .addFilter(RequestLoggingFilter.logRequestTo(Log))
		              .addFilter(ResponseLoggingFilter.logResponseTo(Log))
		    		 .setContentType(ContentType.JSON).build();
		     return Requestspec;
		     
		     
								}
			return Requestspec;
										 
										 
										 
		}				 
		
		public String getJsonPath(Response response,String key)
		{
			  String resp=response.asString();
			JsonPath   js = new JsonPath(resp);
			return js.get(key).toString();
		}

				
		 public String readConfig(String key) throws IOException
		    {
		        try {
		            Properties prop = new Properties();
		            FileInputStream fis= new FileInputStream(pathconstant.Proppath);
		            prop.load(fis);
		            return  prop.getProperty(key);

		        }
		        catch (Exception e)
		        {
		            return null;

		        }
		    }
		 
		    }
