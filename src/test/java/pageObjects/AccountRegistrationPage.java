package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {

		super(driver); //Super keywords to invoked constructor from Base Page
	}
	
	@FindBy(xpath = "//input[@name=\"firstname\"]") WebElement txtFirstName;
	@FindBy(xpath = "//input[@name=\"lastname\"]") WebElement txtLastName;
	@FindBy(xpath = "//input[@name=\"email\"]") WebElement txtEMail;
	@FindBy(xpath = "//input[@name=\"telephone\"]") WebElement taxTelephone;
	@FindBy(xpath = "//input[@name=\"password\"]") WebElement txtPassword;
	@FindBy(xpath = "//input[@name=\"confirm\"]") WebElement txtPasswordConfirm;
	@FindBy(xpath = "//input[@name=\"agree\"]") WebElement chkdPolicy;
	@FindBy(xpath = "//input[@value=\"Continue\"]") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()=\"Your Account Has Been Created!\"]") WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEMail.sendKeys(email);
	}
	public void setTelephoneNo(String tlphn) {
		taxTelephone.sendKeys(tlphn);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String conPwd) {
		txtPasswordConfirm.sendKeys(conPwd);
	}
	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}
	public void clickContinue() {
		//Sol 1
		btnContinue.click();
		
		//Sol 2
//		btnContinue.submit();
		
		//Sol 3
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();
		
		//Sol 4
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("argument[0].click()", btnContinue);
		
		//Sol 5
//		btnContinue.sendKeys(Keys.RETURN);
		
		//Sol 6
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		
	}
	
	public String getConfirmationMessage() {
		try 
		{
		return (msgConfirmation.getText());
		}
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
		

}
