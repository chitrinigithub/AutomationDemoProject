package AutomationDemoProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AutomationDemoProject.pageObjects.IndexPage;
import AutomationDemoProject.pageObjects.RegisterPage;
import AutomationDemoProject.utilities.EventListenerClass;

@Listeners(EventListenerClass.class)

public class AutomationDemoTests extends BaseClass{
	//Test is also a method-----Test method
	@Test(priority=0)
	
	public void verifyIndexPage() {
		
		IndexPage pg= new IndexPage(driver);
		if(pg.getPageTitle().equals("Index")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		pg.clickOnSkipSignButton();
	}
	
	@Test(priority=1)
	public void verifyRegisterUser() throws InterruptedException {
		String message="Please select an item in the list.";
		RegisterPage r= new RegisterPage(driver);
		r.sendKeysToFirstName("abc");
		Thread.sleep(2000);
		r.sendkeysToLastName("mnc");
		Thread.sleep(1000);
		r.sendKeysToEmail(useremail);
		Thread.sleep(2000);
		r.sendKeysToTelephone("1234567890");
		Thread.sleep(2000);
		r.selectRadioButton();
		Thread.sleep(2000);
		r.selectCheckBox();
		Thread.sleep(2000);
		r.uploadFile();
		Thread.sleep(2000);
		try {
			r.sendKeysToCountry();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		r.sendKeysToPassword(passwrd);
		Thread.sleep(2000);
		r.sendKeysToconfirmPassword(passwrd);
		Thread.sleep(2000);
		r.clickOnSubmitButton();
		Thread.sleep(2000);
		Assert.assertEquals(r.getToolTipMessage(), message);
		Thread.sleep(1000);
		
		
	}
	
	
	
	
	
	
	

}
