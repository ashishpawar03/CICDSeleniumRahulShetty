package RahulShettySeleniumFramework.testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTest implements IRetryAnalyzer {

	int count =0;
	int max=1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<max)
		{
			count++;
			return true;
			
		}
		
		return false;
	}
	
	// If test fails then it fall here, it check if condition, if it matches 
				// then go to loop, increase count and returns true, because of true it rerun the TC
				// if it gain fails it again fail then again fall here check if condition, if it matches 
				// then go to loop, increase count and returns true and if it does not match then bypass 
				// the loop and return false. The loop/test executes till it returns true.

}
