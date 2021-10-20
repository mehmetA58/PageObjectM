package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {
    @Test
    public void test() throws InterruptedException {
        //1. Tests packagenin altına class olusturun: D17_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://qa-environment.concorthotel.com/ adresine git.
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //    a. Username : manager
        //    b. Password  : Manager1!
        //5. Login butonuna tıklayın.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
       QAConcortPage qaConcortPage=new QAConcortPage();
       qaConcortPage.firstlogIn.click();
       qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
       qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
       qaConcortPage.logInButton.click();

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.addHotelLink.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        actions.
                click(qaConcortPage.addHotelCodeKutusu).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                perform();

       Select select =new Select(qaConcortPage.selectGroup);
       select.selectByIndex(2);
        //8. Save butonuna tıklayın.
       qaConcortPage.createHotelSave.click();

        //9. “Hotel was inserted successfully” textinin göründüğünü test edin
        Thread.sleep(5000);

       Assert.assertTrue(qaConcortPage.htmlalertYazisi.isDisplayed());
        //10. OK butonuna tıklayın.
       qaConcortPage.alertOk.click();
       //11. Hotel rooms linkine tıklayın.
        qaConcortPage.hotelRoomsButonu.click();

        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(qaConcortPage.listOfHotelRoomsYazisi.isDisplayed());

    }

}
