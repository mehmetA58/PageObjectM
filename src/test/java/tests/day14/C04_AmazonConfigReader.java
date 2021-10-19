package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.security.Key;
// amazon sayfasina gidip
// nutella icin arama yapin
// sonuc sayisini yazdirin ve sonuc yazisinin nutella icerdigini test edin

public class C04_AmazonConfigReader extends TestBase {
    @Test
    public void test(){
        AmazonPage amazonPage=new AmazonPage(driver);
        driver.get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
        System.out.println("amazonPage.sonucYazisiElenmenti.getText() = " + amazonPage.sonucYazisiElenmenti.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElenmenti.getText().contains(ConfigReader.getProperty("amazonArananKelime")));


    }
}
