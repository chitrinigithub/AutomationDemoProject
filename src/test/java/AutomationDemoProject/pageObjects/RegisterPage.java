package AutomationDemoProject.pageObjects;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage {
	//creation of object of webdriver
	
	WebDriver driver;
	
	
	//constructor----Initialization of WebElements with init elements
	
	public RegisterPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Indentify Webelements
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> checkBox;
	
	@FindBy(name="radiooptions")
	List<WebElement> radiooptions;
	
	@FindBy(id="imagesrc")
	WebElement uploadButton;
	
	@FindBy(xpath="//span[@class='selection']/child::span")
	WebElement selectCountry;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement textBoxSelectCountry;
	
	@FindBy(id="firstpassword")
	WebElement password;
	
	@FindBy(id="secondpassword")
	WebElement passwordConfirm;
	
	@FindBy(id="submitbtn")
	WebElement submitButton;
	
	@FindBy(id="countries")
	WebElement country;
	
	
	//Method stsrts here
	
	public void sendKeysToFirstName(String firstname) {
		firstName.clear();
		firstName.sendKeys(firstname);
	}
	
	public void sendkeysToLastName(String lastname) {
		lastName.clear();
		lastName.sendKeys(lastname);
	}
	
	public void sendKeysToEmail(String useremail) {
		email.clear();
		email.sendKeys(useremail);
	}
	
	public void sendKeysToTelephone(String usertelephone) {
		telephone.clear();
		telephone.sendKeys(usertelephone);
	}
	
	public void sendKeysToPassword(String passwrd) {
		password.clear();
		password.sendKeys(passwrd);
	}
	
	public void sendKeysToconfirmPassword(String ConfirmedPassword) {
		passwordConfirm.clear();
		passwordConfirm.sendKeys(ConfirmedPassword);
	}
	
	public void selectRadioButton() {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		for(WebElement r:radiooptions) {
			if(!(r.isSelected())) {
				String radiobutton=r.getAttribute("value");
				if(radiobutton.equals("FeMale")) {
					js.executeScript("arguments[0].click()",r );
				}
			}
		}
	}
	
	public void selectCheckBox() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		for(WebElement c:checkBox) {
			if(!(c.isSelected())) {
				String checkbox=c.getAttribute("value");
				if(checkbox.equals("Cricket") || checkbox.equals("Movies") ) {
					js.executeScript("arguments[0].click()", c);
				}
			}
		}
		
	}
	
	
	public void uploadFile() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",uploadButton );
		uploadButton.sendKeys("C:\\Users\\user\\Downloads\\CoachXTraining\\xpaths.txt");
		
	}
	
	public void sendKeysToCountry() throws AWTException {
		selectCountry.click();
		textBoxSelectCountry.sendKeys("India");
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	//Result of this method---Please select an item in the list
	public String getToolTipMessage() {
		String validationMessage=country.getAttribute("validationMessage");
		return validationMessage;
		
	}
	
	public void handleAlerts() {
		driver.switchTo().alert().dismiss();
	}
	

}
