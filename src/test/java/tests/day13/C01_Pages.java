package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {

    // amazon sayfasina gidip
// nutella icin arama yapin
// sonuc sayisini yazdirin ve sonuc yazisinin nutella icerdigini test edin


    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella", Keys.ENTER);
        WebElement resultYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultYazisi.getText());
        Assert.assertTrue(resultYazisi.getText().contains("nutella"));
    }
    @Test
    public void testPOM(){
        driver.get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("nutella"+Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElenmenti.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElenmenti.getText().contains("nutella"));

    }



}
