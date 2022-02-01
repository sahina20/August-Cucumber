package step_definitions;




import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.MainClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegistrationSuccessPage;

public class RegistrationFunctionalityTest extends MainClass {
    HomePage hp = new HomePage();
    RegisterPage rp = new RegisterPage();
    RegistrationSuccessPage rsp = new RegistrationSuccessPage();
	
	@Given("user is in registration page")
	public void user_is_in_registration_page() {
	
		driver.findElement(By.linkText("REGISTER")).click();
		Assert.assertEquals(driver.getTitle(), prop.getProperty("expectedRegisterPageTitle"));
	}

	@When("user enters {string}, {string} and {string}")
	public void user_enters_username_password_and_confirmPassword 
	(String username, String password, String confirmPassword) {
	  rp.submitRegistrationForm(username, confirmPassword);
	}



	@Then("user should be able to register")
	public void user_should_be_able_to_register() {
	    Assert.assertEquals(rsp.captureRegistrationSuccessPageUrl(), prop.getProperty("registrationSuccessPageUrl"));
	    		
	}

	@And("should be able to see registration success message")
	public void should_be_able_to_see_registration_success_message() {
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@width='492']/tbody/tr[3]/td/p[3]"))
	    		.isDisplayed());
	 
	}	
	
	 @When("user enters {string}, {string} but no confirmPassword")
     public void user_enters_username_password_but_no_confirm_password(String username, String password) {
             driver.findElement(By.name("email")).sendKeys(username);
             driver.findElement(By.name("password")).sendKeys(password);
             driver.findElement(By.name("confirmPassword")).sendKeys("");
     }

     @Then("user should not be able to register")
     public void user_should_not_be_able_to_register() {
        Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("registrationPageUrl"));
     }

     @Then("should see error message")
     public void should_see_error_message() {
             WebElement registrationErrorMsg = driver.findElement(By.xpath(
                             "//input[@name='confirmPassword']/following-sibling::span"));
         Assert.assertEquals(registrationErrorMsg.getText().trim(), 
                     prop.getProperty("expectedRegistrationErrorMsg"));
     }

     @When("user enters no username but enters {string} and {string}")
     public void user_enters_no_username_but_enters_password_confirmPassword
     (String password, String confirmPassword) {
             driver.findElement(By.name("email")).sendKeys("");
             driver.findElement(By.name("password")).sendKeys(password);
             driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
