package RahulShettySeleniumFramework.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/RahulShettySeleniumFramework/cucumberFeatureFile", 
                 glue="RahulShettySeleniumFramework.stepDefination", 
                 monochrome=true, 
                 plugin= {"html:target/cucumber.html"},
                 tags="@Error")

public class CucumberTestRunnerTestNG extends AbstractTestNGCucumberTests{

}
