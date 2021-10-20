package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QAConcortPage {

 WebDriver driver;//--->1.adim

 public QAConcortPage() {//--->2.adim
  PageFactory.initElements(Driver.getDriver(), this);//--->3.adim
 }

 @FindBy(linkText = "Log in")
 public WebElement firstlogIn;
 @FindBy(id = "UserName")
 public WebElement userName;
 @FindBy(id = "Password")
 public WebElement password;
 @FindBy(id = "btnSubmit")
 public WebElement logInButton;
 @FindBy(xpath = "//span[text()='ListOfUsers']")
 public WebElement basariliGirisYazisi;
 @FindBy(xpath = "//*[@id=\"divMessageResult\"]/div/span")
 public WebElement isLoginFailed;

 @FindBy(xpath = "//span[text()='Hotel Management']")
 public WebElement hotelManagementLinki;
 @FindBy(partialLinkText = "Hotel List")
 public WebElement hotelListLink;
 @FindBy(xpath = "(//span[@class='hidden-480'])")
 public WebElement addHotelLink;
 @FindBy(xpath = "(//input[@id='Code'])")
 public WebElement addHotelCodeKutusu;

 @FindBy(id = "btnSubmit")
 public WebElement createHotelSave;

 @FindBy(id = "IDGroup")
 public WebElement selectGroup;

 @FindBy(xpath = "(//div[@class='bootbox-body'])")
 public WebElement htmlalertYazisi;

 @FindBy(xpath = "//button[@class='btn btn-primary']\n")
 public WebElement alertOk;
@FindBy(partialLinkText = "Hotel Rooms")
 public WebElement hotelRoomsButonu;
@FindBy(xpath = "(//span[@class='caption-subject font-green-sharp bold uppercase'])")
 public WebElement listOfHotelRoomsYazisi;
}