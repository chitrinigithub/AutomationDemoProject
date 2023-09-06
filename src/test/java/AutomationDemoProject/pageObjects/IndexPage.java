package AutomationDemoProject.pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class IndexPage {
	//object of webdriver
	
	WebDriver ldriver;
	//Construtor---Initialization of my webelements---Page factory init elements--Supported by selenium webdriver for POM
	
	public IndexPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify the webelemnts ---Page factory gives you an annotation called @FindBy which will help you to locate the elements
	
	@FindBy(id="btn2")
	WebElement skipButton;
	
	
	public void clickOnSkipSignButton() {
		skipButton.click();
		
	}
	
	public String getPageTitle() {
		return (ldriver.getTitle());
	}
	
	
}
