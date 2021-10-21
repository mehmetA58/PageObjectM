package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2EHotelRoomCreation {
    //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
    //2. Bir metod olusturun: RoomCreateTest()










    @Test
    public void RoomCreateTest() throws InterruptedException {
        QAConcortPage qaConcortPage=new QAConcortPage();
        //3. http://qa-environment.koalaresorthotels.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //-->ilk login basamağı unutulmuş
        qaConcortPage.firstlogIn.click();
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        //5. Login butonuna tıklayın.

        qaConcortPage.ConcortHotelLogin();

        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsButonu.click();
        qaConcortPage.addHotelLink.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        Select select=new Select(qaConcortPage.idSelect);
        select.selectByIndex(9);
       Actions actions=new Actions(Driver.getDriver());
       Faker faker=new Faker();
        actions.click(qaConcortPage.addHotelCodeKutusu).
        sendKeys(faker.code().isbnGroup()).
        sendKeys(Keys.TAB).
        sendKeys(faker.name().firstName()).
        sendKeys(Keys.TAB).
        sendKeys(faker.country().name()).
        sendKeys(Keys.TAB).
        sendKeys(faker.funnyName().name()).
        sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("D").
                sendKeys(Keys.TAB).
                sendKeys(faker.number().digit()).
                sendKeys(Keys.TAB).
                sendKeys(faker.number().digit()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

Thread.sleep(3000);
            //8. Save butonuna basin.
qaConcortPage.createHotelSave.click();

Thread.sleep(2000);
//9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(qaConcortPage.htmlalertYazisi.isDisplayed());
//10. OK butonuna tıklayın.
        qaConcortPage.alertOk.click();
actions.sendKeys(Keys.PAGE_UP).perform();
        //11. Hotel rooms linkine tıklayın.
        qaConcortPage.hotelRoomsButonu.click();
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(qaConcortPage.listOfHotelRoomsYazisi.isDisplayed());
        softAssert.assertAll();

        Driver.closeDriver();

    }
}
