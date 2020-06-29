

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass {






    private String getSuccessText(String s) {
        String st = "Success";
        return st;
    }

    public String getErrorText (String cssSelector) {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
        return actualText;
    }

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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }
}
