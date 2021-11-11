package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {
    protected WebDriver driver;

    @Parameters("browser")
   @BeforeClass
    public void setup (@Optional String browser) {
        WebDriverManager.chromedriver().setup();
        driver =DriverCross.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @AfterClass
    public void tearDown() {

       DriverCross.closeDriver();
    }
}

