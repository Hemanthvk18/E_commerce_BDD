package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//run the file with Junit.
@RunWith(Cucumber.class)   
@CucumberOptions(	    
			
		    features= {".//FeaturesFiles/SearchAndOrder.feature"},
		    //features= {".//FeaturesFiles/Register_04.feature"},
			glue="StepsDefination",   
			
			//reports = html ,json and extends report
			plugin= {"pretty", 
					"html:reports/myreport.html", 
					"json:reports/myreport.json",
					 "rerun:target/rerun.txt",
					 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},
					
			dryRun=false, 
			
			monochrome=true,  
			
			publish=true 
			
			//tags="@sanity"  
			
            )

public class Junit_Runner { 
	 

} 
