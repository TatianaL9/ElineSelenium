import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class shopBy {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    void beforeClass() {
        driver.manage().window().maximize();

    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }


    @Test
    public void signInButton() throws InterruptedException {

        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys("tayanalew@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zxc");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zxc");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void CheckQuantity() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> categoryList = driver.findElements(By.cssSelector("[class*='swiper-slide free-mode-slide elb-home-category-swiper"));
        Assert.assertEquals(categoryList.size(), 21);
    }

     @Test
        public void signInButtonWithOutEmail() throws InterruptedException {

            driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#Email")).sendKeys(" ");
            driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zxc#");
            driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zxc#");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(3000);
            String actualText = driver.findElement(By.cssSelector("div.elp-validation-summary validation-summary-errors")).getText();
            Assert.assertEquals(actualText, "Email field is required");
    }


   @Test
    public void LogInButton() throws InterruptedException {

        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Login']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys("tayanalew@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zxc");
        Thread.sleep(2000);
        driver.findElement(By.id("RememberMe")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
    }




    }

