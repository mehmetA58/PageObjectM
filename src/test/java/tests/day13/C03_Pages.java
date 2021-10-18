package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages extends TestBase {
    @Test
    public void test(){
        AmazonPage amazonPage=new AmazonPage(driver);
        // amazon sayfasina gidin




        driver.get("https://www.amazon.com");
        // dropdown menuden book kategorisini secin
        Select select=new Select(amazonPage.dropDownMenu);
        select.selectByVisibleText("Books");
        // java icin arama yapin
        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);
        // bulunan sonuc sayisini yazin
        System.out.println(amazonPage.sonucYazisiElenmenti.getText());
        // ilk urunun isminde Java gectigini test edin

        Assert.assertTrue(amazonPage.ilkÜrun.getText().contains("Java"));

    }
}
