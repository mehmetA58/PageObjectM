package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;

public class Test1_GMIBank_PozitifTest {
GMIBankPage gmiBankPage=new GMIBankPage();

@Test
public void SignInTest(){
    gmiBankPage.GMIBankLogin();
    Assert.assertTrue(gmiBankPage.girisOnay.isDisplayed());

}
@Test
public void SignOutTest(){
    gmiBankPage.girisOnay.click();
    gmiBankPage.cikis.click();
}
}
