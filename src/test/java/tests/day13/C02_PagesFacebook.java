package tests.day13;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {
    //facebook login sayfasina gidin

    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage=new FacebookPage(driver);
       // facebookPage.cookiesgec();
        //kullanici adi: techproed@hotmail.com
        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");
        //sifre:12345
        facebookPage.sifreKutusu.sendKeys("12345");
        //yazdigimizda giris yapamadigimizi test edin
        facebookPage.loginTusu.click();
        Assert.assertTrue(facebookPage.girilemediYaaziElementi.isDisplayed());



    }
}
