import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsEsampleTest extends BaseClass {

    @Test
    public void dropDownExample() throws InterruptedException {
        driver.get("https://elinebox.com/");
        Thread.sleep(3000);
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.cssSelector("a[class ='elb-home-section-title']"));
        //js.executeScript("arguments[].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(4000);
        Select dropdown = new Select(driver.findElement(By.cssSelector("div[class ='ui dropdown mini1 compact fluid elb-sort-order-ddl selection'] [Select='autocomplete']")));
        dropdown.selectByVisibleText("Price: Highest");
        // dropdown.selectByIndex(2);
        Thread.sleep(4000);
//List Price = driver.findElements(By.cssSelector("[class = 'elb-lot-card-price-number']"));
        //System.out.println(Price);
    }

    @Test
    public void dropDownExampl() throws InterruptedException {
        driver.get("https://elinebox.com/Buy?s=20");
        Thread.sleep(5000);
        Select dropdown = new Select(driver.findElement(By.cssSelector("div[class ='ui dropdown mini1 compact fluid elb-sort-order-ddl selection']")));
        dropdown.selectByIndex(2);
        Thread.sleep(2000);
        WebElement option = dropdown.getFirstSelectedOption();
        System.out.println(option.getText());
    }

    @Test
    public void dropDownEx() throws InterruptedException {
        driver.get("https://elinebox.com/Buy?s=20");
        Thread.sleep(5000);
        Select dropdown = new Select(driver.findElement(By.cssSelector("div[class ='ui dropdown mini1 compact fluid elb-sort-order-ddl selection']")));
        dropdown.selectByIndex(2);
        Thread.sleep(2000);
        List <WebElement> options = driver.findElements(By.cssSelector("select autocomplete"));
       for  (int i =0; i < options.size(); i++) {


            System.out.println(options.get(i).getText());
            
        }
    }

}
