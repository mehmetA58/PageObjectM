package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GMIBankPage {
    public GMIBankPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (xpath = "//*[@class='svg-inline--fa fa-user fa-w-14 ']")
    public WebElement ilkGirisButonu;

    @FindBy(xpath = "//span[text()=Sign in']")
    public WebElement signInButonu;
    @FindBy(xpath = "(//li[@id='account-menu'])")
    public WebElement girisOnay;
    @FindBy(linkText = "Sign out")
    public WebElement cikis;
    @FindBy (id = "entity-menu")
    public WebElement myOperations;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    public WebElement manageCustomer;
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement ilkMusteriEdit;
@FindBy(xpath = "(//input[@name='firstName'])")
public WebElement firstName;
@FindBy(xpath = "//tbody//tr[1]//td[2]")
public WebElement ilkMusteriIsmi;
@FindBy(id="save-entity")
public WebElement editSave;

@FindBy(xpath = "//tbody")
public WebElement tumBody;

    public void GMIBankLogin(){
      Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
      Driver.getDriver().findElement(By.xpath("(//li[@id='account-menu'])")).click();
      Driver.getDriver().findElement(By.xpath("(//a[@id='login-item'])")).click();
      Driver.getDriver().findElement(By.xpath("(//input[@name='username'])")).sendKeys(ConfigReader.getProperty("GMIBankValidUsername"));
      Driver.getDriver().findElement(By.xpath("(//input[@name='password'])")).sendKeys(ConfigReader.getProperty("GMIBankValidPassword"));
      Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-primary'])")).click();

    }
}
