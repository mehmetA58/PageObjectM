package tests.day25;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderIleTest {
    @DataProvider
    public static Object[] aranacakKelimeKistesi() {
        String arr[]={"Nutella","Java","Apple","Nane"};

        return arr;
    }

    @Test(dataProvider = "aranacakKelimeKistesi")
    public void test(String aranacakKelime){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage(Driver.getDriver());

        amazonPage.aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        System.out.println(amazonPage.sonucYazisiElenmenti.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElenmenti.getText().contains(aranacakKelime));

}
}
