package scenarios;

import org.testng.annotations.Test;

import Pages.LandingPage;

public class HomePageTest extends Basesetup
{

	@Test
	public void verifyskipsigup()
	{
		
		LandingPage landing = new LandingPage(driver);
		landing.selectSkipSignupbtn();
	}
	
	
	
	
}
