package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features="./src/test/resources/Feature",glue={"com.stepDef","Base"},
		tags= "@positive or @negative",
		plugin = {
				"pretty", 
				"html:target/cucumber-reports.html",
				"json:target/JsonReport/Amazon.json", 
				"junit:target/JunitReport/Amazon.junit"
		}
		)
public class TestRunner extends AbstractTestNGCucumberTests {




}
