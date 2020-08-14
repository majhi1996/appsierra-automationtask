package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserDetailspage 
{
public WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[text()='Ticket Details']")
	public WebElement ticketdetailstext;
	
	@FindBy(how=How.ID,using="secure-trip")
	public WebElement securetrip;
	
	@FindBy(how=How.NAME,using="Adultchoose1")
	public WebElement title;
	
	@FindBy(how=How.NAME,using="AdultfirstName1")
	public WebElement firstname;	

	@FindBy(how=How.NAME,using="AdultmiddleName1")
	public WebElement middlename;
	
	@FindBy(how=How.NAME,using="AdultlastName1")
	public WebElement lastname;
	
	@FindBy(how=How.NAME,using="email")
	public WebElement email;
	
	@FindBy(how=How.NAME,using="mobile")
	public WebElement phone;
	
	@FindBy(how=How.XPATH,using="//*[text()='Proceed ']")
	public WebElement proceedbutton;
	
	@FindBy(how=How.XPATH,using="//*[text()='Ok']")
	public WebElement Okbutton;
	
	@FindBy(how=How.XPATH,using="//*[text()='OK']")
	public WebElement OKbutton;
	
	@FindBy(how=How.XPATH,using="//*[text()='Skip to Payment']")
	public WebElement skipbutton;
	
	@FindBy(how=How.XPATH,using="//*[text()='Wallets']")
	public WebElement wallet;	
	
	public UserDetailspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnSecureTrip()
	{
		securetrip.click();
	}
	
	public void selectTitle(String Title)
	{
		Select s=new Select(title);
		s.selectByVisibleText(Title);
	}
	
	public void fillFirstName(String firstName)
	{
		firstname.sendKeys(firstName);
	}
	
	public void fillMiddleName(String middleName)
	{
		middlename.sendKeys(middleName);
	}
	
	public void fillLastName(String lastName)
	{
		lastname.sendKeys(lastName);
	}
	
	public void fillEmail(String emailId)
	{
		email.sendKeys(emailId);
	}
	
	public void fillPhone(String Mobile)
	{
		phone.sendKeys(Mobile);
	}
	
	public void clickProceedBtn()
	{
		proceedbutton.click();
	}
	
	public void clickOk()
	{
		Okbutton.click();
	}	
	
	public void clickOK()
	{
		OKbutton.click();
	}
	
	public void skipToPayment()
	{
		skipbutton.click();
	}
	
	public void clickWallet()
	{
		wallet.click();
	}
}
