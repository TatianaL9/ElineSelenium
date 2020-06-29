package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseTest {
  public LoginPage (WebDriver givendriver) {
      driver = givendriver;
      wait = new WebDriverWait(driver,4 );
  }
@Test
    public void LoginSuccessTest () {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.openHomePage();
    loginPage.openLoginPage();
    loginPage.enterEmail("tayanalew@gmail.com");
    loginPage.enterPassword("123321Z#xc");
    loginPage.enterConfirmPassword("123321Z#xc");
    loginPage.cli




}




  private String getSuccessText(String s) {
        String st = "Success";
        return st;
    }

    public String getErrorText (String cssSelector) {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
        return actualText;
    }
    public void openHomePage() {
        driver.get("https://elinebox.com/");
    }

    public void AcceptCookies() {
        WebElement AcceptCookies = driver.findElement(By.cssSelector("#CookiePolicyAcceptBtn"));  AcceptCookies.click();}
    public void openLoginPage() {
        driver.get("https://elinebox.com/");
    }

    public void enterEmail(String email) {
        findElement("#Email").sendKeys(email);
    }

    public void enterPassword(String password) {
        findElement("#password").sendKeys(password);
    }

    public void enterConfirmPassword(String ConfirmPassword) {
        findElement("#ConfirmPassword").sendKeys(ConfirmPassword);
    }

    public WebElement findElement(String cssSelector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void clickToElement (String cssSelector)  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }
}