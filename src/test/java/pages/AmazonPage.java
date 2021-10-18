package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
    WebDriver driver;
//bir page sayfasi oluşturulduğunda mutlaka(must)yapmamız gereken şey
    //bir constructor oluşturup driver'a ilk degeri atamanktir(instantiate)
    public AmazonPage(WebDriver driver){//------>yeni sayfa oluştururken bunu copy-paste yapabilirdik ama yapmadık :)<---------
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


// WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])")
    public WebElement sonucYazisiElenmenti;

    @FindBy (id="searchDropdownBox")
    public WebElement dropDownMenu;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement ilkÜrun;



}
