package com.app.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags = "@HRAppDB",
		features= {"src/test/resources/com/app/features/","src/test/resources/com/app/hrapp_features/"},
		glue="com/app/step_definitions/",
		dryRun=false 
)
public class CukesRunner extends AbstractTestNGCucumberTests {

}
