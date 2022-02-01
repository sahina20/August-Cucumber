package step_definitions;

import Base.MainClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends MainClass {
 //handle prerequisite and post req steps
// Pre requisite
 @Before
 public void loadBrowser() {
	intialization();
}

 @After
 public void closeBrowser() {
	 tearDown();
 }





}
