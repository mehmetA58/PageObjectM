package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLogintest {

    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        // https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        // login butonuna bas
        //test data username: manager ,
        //test data password : Manager1!

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(qaConcortPage.basariliGirisYazisi.isDisplayed(),"basaşarılı giriş yazisi gözükmüyor");



        Driver.closeDriver();





    }
}
