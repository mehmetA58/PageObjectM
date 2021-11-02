package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class GMIBankMusteriOlusturma {
    GMIBankPage gmiBankPage=new GMIBankPage();
    @Test
    public void Test1() throws InterruptedException {
        gmiBankPage.GMIBankLogin();
        gmiBankPage.myOperations.click();
        gmiBankPage.manageCustomer.click();
        gmiBankPage.ilkMusteriEdit.click();
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        gmiBankPage.firstName.clear();
        gmiBankPage.firstName.click();
        String firstName=faker.name().firstName();

        actions.sendKeys(firstName).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().nameWithMiddle())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("PhoneNumber"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("PhoneNumber"))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.idNumber().ssnValid())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().country())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .perform();

        gmiBankPage.editSave.click();
Thread.sleep(2000);
        Assert.assertTrue(firstName.equals(gmiBankPage.ilkMusteriIsmi.getText()));
        System.out.println(firstName);
        System.out.println(gmiBankPage.ilkMusteriIsmi.getText());

        Assert.assertTrue(gmiBankPage.tumBody.getText().contains(firstName));

    }
}
