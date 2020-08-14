package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightpage 
{
	public WebDriver driver;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Flight Details'])[1]")
	public WebElement flightdetailstext;
	
	@FindBy(how=How.XPATH,using="(//*[text()='PRICE'])[1]")
	public WebElement sort1;
	
	@FindBy(how=How.XPATH,using="(//*[text()='PRICE'])[2]")
	public WebElement sort2;
	
	@FindBy(how=How.XPATH,using="(//*[text()='ARRIVAL'])[2]")
	public WebElement arrivaltext;
	
	@FindBy(how=How.XPATH,using="//*[@class='fltHpyRWrap dF justifyBetween']/div[1]/div/div[1]/div/div[2]/div[2]/div/span[2]/label")
	public WebElement highestprice1;
	
	@FindBy(how=How.XPATH,using="//*[@class='fltHpyRWrap dF justifyBetween']/div[2]/div/div[1]/div/div[2]/div[2]/div/span[2]/label")
	public WebElement highestprice2;
	
	@FindBy(how=How.XPATH,using="//input[@value='BOOK']")
	public WebElement bookbutton; 
	
	public SelectFlightpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnSortArrow1()
	{
		sort1.click();
	}
	
	public void clickOnSortArrow2()
	{
		sort2.click();
	}
	
	public void clickRadioBtn1()
	{
		highestprice1.click();
	}
	
	public void clickRadioBtn2()
	{
		highestprice2.click();
	}	
	
	public void clickBook()
	{
		bookbutton.click();
	}
}