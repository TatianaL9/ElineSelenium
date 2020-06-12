
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;


public class BaseClass {

    WebDriver driver;

    @BeforeClass
    void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }



}

