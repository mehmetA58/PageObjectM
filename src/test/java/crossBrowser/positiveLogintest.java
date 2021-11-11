package crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class positiveLogintest extends TestBaseCross {

    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        // https://qa-environment.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHQAUrl"));
        // login butonuna bas
        driver.findElement(By.linkText("Log in")).click();
        //test data username: manager ,
        driver.findElement(By.id("UserName")).sendKeys(ConfigReader.getProperty("CHValidUsername"));
        //test data password : Manager1!
        driver.findElement(By.id("Password")).sendKeys(ConfigReader.getProperty("CHValidPassword"));
        driver.findElement(By.id("btnSubmit")).click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        WebElement basariliGirisYaziElementi=driver.findElement(By.xpath("xpath = //span[text()='ListOfUsers']"));
        Assert.assertTrue(basariliGirisYaziElementi.isDisplayed());
    }
}
