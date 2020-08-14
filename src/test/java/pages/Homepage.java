package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	public WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[text()='Round trip']")
	public WebElement roundtriptext;
	
	@FindBy(how=How.XPATH,using="//*[@placeholder='From']")
	public WebElement from;
	
	@FindBy(how=How.XPATH,using="//*[text()='Delhi Airport']")
	public WebElement delhiairport;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Shivaji International Airport')]")
	public WebElement mumbaiairport;
	
	@FindBy(how=How.XPATH,using="//*[@placeholder='Destination']")
	public WebElement dest;
	
	@FindBy(how=How.XPATH,using="//*[@placeholder='Departure']")
	public WebElement departuredropdown;
	
	@FindBy(how=How.ID,using="fare_20200825")
	public WebElement departuredate;
	
	@FindBy(how=How.XPATH,using="//*[@placeholder='Return']")
	public WebElement returndropdown;
	
	@FindBy(how=How.ID,using="fare_20200830")
	public WebElement returndate;	
	
	@FindBy(how=How.XPATH,using="//*[@value='Search']")
	public WebElement searchbutton;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnRoundTrip()
	{
		roundtriptext.click();
	}
	
	public void fillplaceFrom(String place)
	{
		from.sendKeys(place);
	}
	
	public void fillplaceTo(String place)
	{
		dest.sendKeys(place);
	}	
	
	public void clickDepartureDate()
	{
		departuredropdown.click();
		departuredate.click();
	}
	
	public void clickReturnDate()
	{
		returndropdown.click();
		returndate.click();
	}
	
	public void clickSearch()
	{
		searchbutton.click();
	}
}
