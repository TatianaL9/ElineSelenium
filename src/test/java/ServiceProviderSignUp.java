import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServiceProviderSignUp extends BaseClass {

    @DataProvider(name = "SignInProviders")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"tayanalew@gmail.com", "", "123321Zx#c", "The Password field is required.\n" +
                        "The password and confirmation password do not match."},
                {"tayanalew@gmail.com", "123321Zx#c", "", "The password and confirmation password do not match."},
                {"", "", "123321Zx#c", "The Email field is required.\n" +
                        "The Password field is required.\n" +
                        "The password and confirmation password do not match."}
        };

    }

    @Test(dataProvider = "SignInProviders")
    public void signInButton(String email, String password, String confirmPassword, String error) throws InterruptedException {
        driver.get("https://elinebox.com/");
        Thread.sleep(3000);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='elp-validation-summary validation-summary-errors']")).getText(), error);
    }
}

