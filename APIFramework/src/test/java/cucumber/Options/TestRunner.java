package cucumber.Options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions

(   
		
		features ="src/test/java/features",
        
        glue ={"stepDefinations"},
   //tags="@APi1",
       monochrome=true
		//plugin= {"pretty",
				//"html:target/cucumber.html",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		
		
		)
public class TestRunner {
	
}


