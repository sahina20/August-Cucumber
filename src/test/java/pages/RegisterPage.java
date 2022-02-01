package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.MainClass;



public class RegisterPage extends MainClass {

	//driver.findElement(By.name("email")).sendKeys(username);
	//driver.findElement(By.name("password")).sendKeys(password);
	//driver.findElement(By.name("confirmPassword")).sendKeys(password);
	//driver.findElement(By.name("submit")).click()
	
	@FindBy(name="email")
	WebElement usernameTxtField;
	@FindBy(name="password")
	WebElement passwordTxtField;
	@FindBy(name= "confirmPassword")
	WebElement confirmPasswordTxtField;
	@FindBy(name="submit")
	WebElement submitBtn;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void submitRegistrationForm(String username, String password) {
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		confirmPasswordTxtField.sendKeys(password);
		submitBtn.click();
	}
	

	public String captureRegisterPageTitle() {
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
}
