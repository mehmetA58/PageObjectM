package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle  extends TestBase {
    @Test
    public void positiveTestCongif(){

        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        // login butonuna bas
        concortHotelPage.firstlogIn.click();
        // test data username: manager ,
        concortHotelPage.userName.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        // test data password : Manager1!
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.logInButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYazisi.isDisplayed());
    }
}
