package StepDef;

import Base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest{
	 @Before
	    public void setUp() throws Exception {
	        driver = InitiateDriver();   // your driver initialization method
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
