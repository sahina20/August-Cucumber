package pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.MainClass;




public class HomePage extends MainClass {
	
	//@FindBy
	@FindBy(name="userName")
	WebElement userNameTxtField;
	@FindBy(name="password")
	WebElement passwordTxtField;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(linkText="REGISTER")
	WebElement registerLink;
	@FindBy(xpath ="//input[@name='password']/following-sibling::br/following-sibling::span")
	WebElement loginErrorMsg;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName (String username) {
		userNameTxtField.sendKeys(username);
	}

	public void enterPassword (String password ) {
		userNameTxtField.sendKeys(password);
	}
	
	public void clickSubmitBtn () {
		submitBtn.click();
	}
	
	public void clickRegisterLink () {
		registerLink.click();
	}
	
	public String captureHomePageTitle() {
		return driver.getTitle();
		}
	
	
	public void hittingEnterKey() {
		 Actions action = new Actions(driver);
         action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public String captureHomePageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean validatePresenceLoginErrorMsg() {
		return loginErrorMsg.isDisplayed();
	}
	
	
}
