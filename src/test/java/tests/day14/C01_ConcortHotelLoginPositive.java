package tests.day14;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;
public class C01_ConcortHotelLoginPositive extends TestBase {
    //1 ) Bir Class olustur : PositiveTest
    //2) Bir test method olustur positiveLoginTest()
    // https://www.concorthotel.com/ adresine git
    @Test
    public void positiveLoginTest(){
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        // login butonuna bas
        concortHotelPage.firstlogIn.click();
        // test data username: manager ,
        concortHotelPage.userName.sendKeys("manager");
        // test data password : Manager1!
        concortHotelPage.password.sendKeys("manager1!");
        concortHotelPage.logInButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYazisi.isDisplayed());
    }
}