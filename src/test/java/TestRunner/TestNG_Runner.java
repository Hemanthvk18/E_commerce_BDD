package TestRunner;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//run the file with TestNG.
@CucumberOptions(	    
			//features= {".//FeaturesFiles/Login.feature"}
			features= {".//FeaturesFiles/Formfill.feature"},
			
			glue="StepsDefination",   
			
			//reports = html ,json and extends report
			plugin= {"pretty", 
					"html:reports/myreport.html", 
					"json:reports/myreport.json",
					 "rerun:target/rerun.txt",
					 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},
					
			monochrome=true  
			
			)
			
		
public class TestNG_Runner extends AbstractTestNGCucumberTests   
{  
	@DataProvider(parallel=true)  
    public Object[][] senarios()
    {
	   return super.scenarios();
    }
} 


