package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {

    @Test
    public void test(){





        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHQAUrl"));
        // login butonuna bas
        concortHotelPage.firstlogIn.click();
        // test data username: manager1
        concortHotelPage.userName.sendKeys(ConfigReader.getProperty("CHInValisUsername"));
        // test data password : manager1!
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword")+ Keys.ENTER);

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue((concortHotelPage.isLoginFailed.isDisplayed()));



    }
}
