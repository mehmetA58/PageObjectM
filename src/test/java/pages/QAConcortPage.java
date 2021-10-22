package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

 WebDriver driver;//--->1.adim

 public QAConcortPage() {//--->2.adim
  PageFactory.initElements(Driver.getDriver(), this);//--->3.adim
 }





 public void ConcortHotelLogin(){
  Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
  QAConcortPage qaConcortPage=new QAConcortPage();
  qaConcortPage.firstlogIn.click();
  qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
  qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
  qaConcortPage.logInButton.click();
 }

 @FindBy(xpath = "//thead//tr[1]//th")
 public List<WebElement> basliklarListesi;

 @FindBy(xpath = "//tbody")
 public List<WebElement> tBodyTumu;

 @FindBy(xpath ="//tbody//tr")
 public List<WebElement> satirlarListesi;

 @FindBy(xpath = "//tbody//tr[1]")
 public WebElement birinciSatir;
 @FindBy(xpath = "//tbody/tr//td[4]")
 public List<WebElement> dorduncuSutunListesi;
@FindBy (xpath = "//tbody//tr//td")
public List<WebElement> tumHucrelerListesi;

@FindBy (xpath = "//tbody//tr[1]//td")
public  List<WebElement> columnListesi;

@FindBy(xpath = "//tbody//tr//td[5]")
public List<WebElement> besinciSutunListesi;
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
@FindBy (id="IDHotel")
public WebElement idSelect;


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

 @FindBy(id = "IDHotel")
 public WebElement addRoomIdDropDown;

 public String printData(int satir, int sutun) {
  // ornekteki haliyle 3.satir, 5.sutundaki elemani yazdiralim
  //  String xpath= //tbody//tr[3]//td[5]
  // degismeyecek kisimlari String, degisecek kisimlari ise parametre ismi olarak yazdik
  String xpath= "//tbody//tr[" + satir +"]//td["+ sutun + "]";
  //System.out.println(xpath);

  // satir no : 3, sutun no : 5
  //System.out.println("satir no : "+ satir+ " sutun no : " + sutun);

  // @FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim
  String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
  System.out.println("satir no  "+ satir+ ", sutun no : " + sutun + "'deki data : " + istenenData );

  return istenenData;
 }
}