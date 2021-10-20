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
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.firstlogIn.click();

        //test data username: manager ,
        //test data password : Manager1!
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        qaConcortPage.logInButton.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(qaConcortPage.basariliGirisYazisi.isDisplayed());

Driver.closeDriver();





    }
}
