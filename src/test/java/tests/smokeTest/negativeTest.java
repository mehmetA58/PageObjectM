package tests.smokeTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
public class negativeTest {
    // 1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    //              - yanlisSifre
    //              - yanlisKulllanici
    //              - yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1!
    //2) https://qa-environment.concorthotel.com/ adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
   QAConcortPage qaConcortPage;
    @Test(priority = -5,groups = "birinciGrup")
    public void yanlisSifre() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.firstlogIn.click();
      qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
      qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
      qaConcortPage.logInButton.click();
      Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed(),"giriş başarılı");
    Driver.closeDriver();
    }
    @Test
    public void yanlisKullanici(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.firstlogIn.click();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();
        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed(),"giriş başarılı");

    }
    @Test
    public void yanlisSifreKullanici(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.firstlogIn.click();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.logInButton.click();
        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed(),"giriş başarılı");

    }
}