package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {
    @Test

    public void test(){
      //https://the-internet.herokuapp.com/windows
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String birinciSayfaninHandle=Driver.getDriver().getWindowHandle();
        //click here yazisina basalim
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
       Set<String> windowHandleKumesi= Driver.getDriver().getWindowHandles();

       String ikinciSayfaHandleDegeri=" ";

        for (String w:windowHandleKumesi) {
            if(!w.equals(birinciSayfaninHandle)){
                ikinciSayfaHandleDegeri=w;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());

//yeni sayfada New Window yazisinin gorundugunu test edelim
        Assert.assertTrue(Driver.getDriver().findElement(By.tagName("h3")).isDisplayed());
Driver.closeDriver();
    }
    @Test
    public void testReusableIle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }


}
