package tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.SelectFlightpage;
import pages.UserDetailspage;
import utilities.TestUtility;

public class Runner 
{
	public WebDriver driver;
	public WebDriverWait w;
	public Properties p;
	public Homepage hp;
	public SelectFlightpage fp;
	public UserDetailspage up;
	public TestUtility tu;
	
	
	@BeforeTest
	public void setup() throws Exception
	{
		FileInputStream fi=new FileInputStream("D:\\Selenium4\\com.appsierra.webdevelopment\\src\\test\\java\\properties\\data.properties");
		p=new Properties();
		p.load(fi);		
		tu=new TestUtility();
	}
	
	@Test(priority=1)
	public void searchFlight() throws Exception
	{		
		driver=tu.openBrowser("chrome");		
		driver.manage().window().maximize();
		hp=new Homepage(driver);
		w=new WebDriverWait(driver,50);
		tu.launchSite(p.getProperty("url"));
		w.until(ExpectedConditions.visibilityOf(hp.roundtriptext));
		hp.clickOnRoundTrip();
		hp.fillplaceFrom("Delhi (DEL)");
		w.until(ExpectedConditions.visibilityOf(hp.delhiairport));
		hp.from.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		hp.fillplaceTo("Mumbai (BOM)");
		w.until(ExpectedConditions.visibilityOf(hp.mumbaiairport));
		hp.dest.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		hp.clickDepartureDate();
		hp.clickReturnDate();
		hp.clickSearch();		
	}
	
	@Test(priority=2)
	public void bookFlight()
	{
		fp=new SelectFlightpage(driver);
		w.until(ExpectedConditions.visibilityOf(fp.flightdetailstext));
		fp.clickOnSortArrow1();
		w.until(ExpectedConditions.visibilityOf(fp.arrivaltext));
		fp.clickOnSortArrow2();
		fp.clickRadioBtn1();
		fp.clickRadioBtn2();
		fp.clickBook();
	}
	
	@Parameters({"title","firstname","middlename","lastname","email","phone"})
	@Test(priority=3)
	public void userDetails(String title, String firstname, String middlename, String lastname, String email, String phone) throws Exception
	{
		up=new UserDetailspage(driver);
		w.until(ExpectedConditions.visibilityOf(up.ticketdetailstext));
		Thread.sleep(5000);
		up.clickOnSecureTrip();
		up.selectTitle(title);
		up.fillFirstName(firstname);
		up.fillMiddleName(middlename);
		up.fillLastName(lastname);
		up.fillEmail(email);
		up.fillPhone(phone);
		up.clickProceedBtn();
		w.until(ExpectedConditions.visibilityOf(up.Okbutton));
		up.clickOk();
		w.until(ExpectedConditions.visibilityOf(up.OKbutton));
		up.clickOK();
		w.until(ExpectedConditions.visibilityOf(up.skipbutton));
		up.skipToPayment();
		w.until(ExpectedConditions.visibilityOf(up.wallet));
		up.clickWallet();		
	} 
	
	@AfterTest
	public void stopExecution()
	{ 
		tu.closeSite();
		
	}
}
