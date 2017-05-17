

  package pffcu.Testpage;

  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.support.PageFactory;
  import org.testng.Assert;
  import org.testng.annotations.AfterTest;
  import org.testng.annotations.BeforeTest;
  import org.testng.annotations.DataProvider;
  import org.testng.annotations.Test;

  import CommonMethods.commonMethods;
  import excelExportandFileIO.ExcelFile;
  import pffcu.PageObjects.AlternateLoginPageObject;
  import pffcu.PageObjects.PffcHomepageObj;

  public class PageTest1 {
  WebDriver driver;
  commonMethods helper;
  PffcHomepageObj Object;
  AlternateLoginPageObject test;
  ExcelFile file;

  public PageTest1(){

  }
  @BeforeTest
  public void connect(){
  driver = commonMethods.Setup("https://www.org", "firefox");
  System.out.println(driver.getTitle());
  }

  @Test
  public void loginTest(){
  Object = PageFactory.initElements(driver, PffcHomepageObj.class);
  Object.userID("omoe");
  Object.Password("Password");
  Object.Click_submit();
  Assert.assertTrue(driver.getTitle().contains("People First Federal Credit Union"), "user is not able to login");
  System.out.println("login successfully");
  }

  @Test(dataProvider = "pffcuData")
  public void login2(String UserID, String Password) throws Exception{
  test = PageFactory.initElements(driver, AlternateLoginPageObject.class);
  test.login2(UserID, Password);
  driver.getTitle();
  Thread.sleep(5000);

  }

  @DataProvider(name = "pffcuData")
  public Object[][] passData(){
  Object[][] data = new Object[3][2];
  data[0][0] = "Doyin";// username
  data[0][1] = "gooder";//password
  data[1][0] = "Doyin2";
  data[1][1] = "Flow_Job";

  data[2][0] = "omo1"
  data[2][1] = "People";
  return data;

  }
  @AfterTest
  public void tearDown(){
  driver.quit();
  }

  }

