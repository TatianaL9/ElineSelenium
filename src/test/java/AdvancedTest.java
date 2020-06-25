import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

import javax.swing.*;

public class AdvancedTest extends BaseClass {

    @Test
    public void AcceptCookies() {
        driver.get("https://elinebox.com/");
        WebElement AcceptCookies = driver.findElement(By.cssSelector("#CookiePolicyAcceptBtn"));
        AcceptCookies.click();
        if (!driver.findElement(By.cssSelector("#CookiePolicyCard")).isDisplayed()) {
            System.out.println("YESSSSSS");
        } else {
            System.out.println("NOOOOOO");
        }

    }


    @Test
    public void scrollingTest() throws InterruptedException {

        driver.get("https://elinebox.com/");
        WebElement job = driver.findElement(By.cssSelector(".elb-home-phone-right"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert ('hi');");
        Thread.sleep(5000);
    }


    @Test
    public void keysTest() throws InterruptedException {
        driver.get("https://elinebox.com/Account/Login");
        //intiate action class
        Actions builder = new Actions(driver);
        // find search element
        WebElement element = driver.findElement(By.cssSelector("#Email"));
     // perform series of actions
        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .keyDown(element, Keys.SHIFT)
                .sendKeys(element, "Hi")
                .doubleClick(element)
                .contextClick()
                .build();
        seriesOfActions.perform();
        Thread.sleep(6000);

    }

    @Test
    public void hover() throws InterruptedException {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        Actions builder = new Actions(driver);
        // find search element
        WebElement elem = driver.findElement(By.cssSelector("#sub-menu"));
        // perform series of actions
        Action mouseOverHome = builder.moveToElement(elem).build();
        mouseOverHome.perform();
        driver.findElement(By.cssSelector("#link2")).click();
        Thread.sleep(5000);
    }

}

