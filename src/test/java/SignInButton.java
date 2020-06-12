import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignInButton extends BaseClass {



    @Test
    public void signInButton() throws InterruptedException {

        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys("tayanalew@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void signInButtonWithOutEmail() throws InterruptedException {

        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        //   driver.findElement(By.cssSelector("#Email")).sendKeys("");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        String actualText = driver.findElement(By.cssSelector("div.elp-validation-summary validation-summary-errors")).getText();
        Assert.assertEquals(actualText, "Email field is required");
    }

    @Test
    public void signInButtonWithoutFirstPassword() throws InterruptedException {

        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys("tayanalew@gmail.com");
        // driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zxc");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zx#c!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        String actualText = driver.findElement(By.cssSelector("div[class='elp-validation-summary validation-summary-errors'")).getText();
        //System.out.println(actualText);
      Assert.assertEquals(actualText, "The Password field is required. The password and confirmation password do not match.");
    }

    @Test
    public void signInButtonWithoutConfirmPassword() throws InterruptedException {
        driver.get("https://elinebox.com/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys("tayanalew@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        String actualText = driver.findElement(By.cssSelector("div[class='elp-validation-summary validation-summary-errors'")).getText();
        Assert.assertEquals(actualText, "The password and confirmation password do not match.");
    }

}
