
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 4);

    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }



}

