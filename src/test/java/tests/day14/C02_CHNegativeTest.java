package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_CHNegativeTest extends TestBase {
    @Test
    public void test(){
//Bir test method olustur NegativeLoginTest()
// https://www.concorthotel.com/ adresine git



// Degerleri girildiginde sayfaya girilemedigini test et
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);


        // login butonuna bas
        concortHotelPage.firstlogIn.click();

        // test data username: manager1 ,
        concortHotelPage.userName.sendKeys("manager1");

        // test data password : manager1!
        concortHotelPage.password.sendKeys("manager1!");
        concortHotelPage.logInButton.click();
        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.isLoginFailed.isDisplayed());
    }
}
