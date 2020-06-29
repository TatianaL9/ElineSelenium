import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignInButton extends BaseClass {

    //new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBe(By.ByCssSelector("0"), "")));
//assertThat(driver.findElement(By.ByCssSelector("span"))).getText()).isNotEmpty();
    public void openHomePage() {
        driver.get("https://elinebox.com/");
    }
    public void openLoginPage() {driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();}
    public void AcceptCookies() {
        WebElement AcceptCookies = driver.findElement(By.cssSelector("#CookiePolicyAcceptBtn"));  AcceptCookies.click();}
    private String getSuccessText(String s) { String st = "Success";
        return st; }

    public String getErrorText (String cssSelector) {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
        return actualText; }
    public void enterEmail(String email) { findElement("#Email").sendKeys(email); }
    public void enterPassword(String password) { findElement("#password").sendKeys(password); }
    public void enterConfirmPassword(String ConfirmPassword) { findElement("#ConfirmPassword").sendKeys(ConfirmPassword); }
   public void clickSubmit() {
       WebElement click = clickToRegisterElement().click();
   }
    public WebElement findElement(String cssSelector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))); }

    public void clickToRegisterElement ()  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))); }

        @Test
    public void signInButton() throws InterruptedException {
        openHomePage();
        openLoginPage();
        AcceptCookies();
            driver.findElement(By.cssSelector("#Email")).sendKeys("tanya.levchenko.ca@gmail.com");
            enterPassword("123321Zx#c");
            driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zx#c");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Test
    public void signInButtonWithOutEmail() throws InterruptedException {
        openHomePage();
        openLoginPage();
        AcceptCookies();
        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        //   driver.findElement(By.cssSelector("#Email")).sendKeys("");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String actualText = driver.findElement(By.cssSelector (".elp-validation-summary ul li")).getText();
        Assert.assertEquals(actualText, "The Email field is required.");
    }



    @Test
    public void signInButtonWithoutFirstPassword() throws InterruptedException {
        openHomePage();
        openLoginPage();
        AcceptCookies();
        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Email")).sendKeys("tanya.levchenko.ca@gmail.com");
        // driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zxc");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123321Zx#c!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        String actualText = driver.findElement(By.cssSelector(".elp-validation-summary ul li")).getText();
        //System.out.println(actualText);
      Assert.assertEquals(actualText, "The Password field is required.");
    }

    @Test
    public void signInButtonWithoutConfirmPassword() throws InterruptedException {
        openHomePage();
        openLoginPage();
        AcceptCookies();
        driver.findElement(By.cssSelector("div[class='elb-header-top-menu-items'] a[href='/Account/Register']")).click();
        driver.findElement(By.cssSelector("#Email")).sendKeys("tanya.levchenko.ca@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123321Zx#c");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String actualText = driver.findElement(By.cssSelector(".elp-validation-summary ul li")).getText();
        Assert.assertEquals(actualText, "The password and confirmation password do not match.");
    }

}
