package pffcu.PageObjects

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PffcHomepageObj {
	WebDriver driver;


	public PffcHomepageObj(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "userid")
		WebElement username;
	@FindBy(how = How.ID, using = "password")
		WebElement pwd;
	@FindBy(how = How.CSS, using = "form#Login input[type='submit']")
		WebElement submitBtn;
	@FindBy(how = How.LINK_TEXT, using = "forgot User ID or Password")
		WebElement forgot_login;
	@FindBy(how = How.LINK_TEXT, using = "credit card Access")
		WebElement CC_loginPage;



	public void userID(String Username){
		username.sendKeys(Username);

	}
	 public void Password(String password){
		 pwd.sendKeys(password);
	 }
	 public void Click_submit(){
		 submitBtn.click();
	 }
	 public void resetID(){
		 forgot_login.click();
	 }
	 public void CC_link(){
		 CC_loginPage.click();
	 }

 } 
