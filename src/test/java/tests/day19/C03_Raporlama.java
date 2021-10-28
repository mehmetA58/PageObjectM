package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Arrays;

public class C03_Raporlama extends TestBaseRapor {

    @Test
    public void test1(){
        extentTest=extentReports.createTest("nutella testi","nutella sonuc sayisini test eder");
        //amazon sayfasina gidip
        Driver.getDriver().get("https://www.amazon.com");
        extentTest.info("istenen adrese gidildi");
        //nutella icin arama yapıp
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        extentTest.info("test edecegimiz locate girildi");
        //sonuc sayisinin 1000'den az oldugunu test edelim
        WebElement sonucSayisiYazisi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        extentTest.info("sonuc yazisi locate edildi");
        String sonucYazisi=sonucSayisiYazisi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");
        int sonucSayisi=Integer.parseInt(sonucArrayi[2]);
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisi test edildi");


    }
    @Test
    public void test2(){
        extentTest=extentReports.createTest("samsung testi","sonuc sayisini test eder");
        //amazon sayfasina gidip
        Driver.getDriver().get("https://www.amazon.com");
        extentTest.info("istenen adrese gidildi");
        //samsung icin arama yapıp
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("samsung"+ Keys.ENTER);
        //sonuc sayisinin 1000'den az oldugunu test edelim
        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        //1-48 of 130 results for

        String sonucYazisi=sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");

        String sonucAdedi=sonucArrayi[3];
        sonucAdedi=sonucAdedi.replace(",","");
        System.out.println(sonucAdedi);
        int sonucSayisi= Integer.parseInt(sonucAdedi);

        extentTest.info("sonuc yazisi int haline getirildi");
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000'den az oldugu test edildi");

    }
    @Test
    public void test3(){
        extentTest=extentReports.createTest("samsung testi","sonuc sayisini test eder");
        //amazon sayfasina gidip
        Driver.getDriver().get("https://www.amazon.com");
        //electronic kategorisinde java icin arama yapıp
        Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);
        //çıkan sonuçlardan ilkinin isminde java olduğunu test edelim
        WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("(//div[@class='s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom'])[1]"));
        String ikinciElementYazisi=ikinciUrun.getText();
        Assert.assertTrue(ikinciElementYazisi.contains("Java"));
        extentTest.pass("ilk urun isminde java oldugu test edildi");
    }
}
