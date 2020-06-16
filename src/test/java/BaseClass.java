
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    WebDriver driver;

    @BeforeClass
    void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }



}

