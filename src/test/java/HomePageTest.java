import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class HomePageTest extends BaseClass {

    @Test
    public void titleTest() throws InterruptedException {
        driver.get("https://elinebox.com/");
        wait.until(ExpectedConditions.titleIs("Home - eLineBox"));
        String Title = driver.getTitle();

        Assert.assertEquals(Title, "Home - eLineBox");
    }

    @Test
    public void StartGrowingYourBusinessPresent() throws InterruptedException {

        WebElement mainText = driver.findElement(By.className("elb-header-big-text"));
        String mainT = mainText.getText();

        //  System.out.println(mainText.getText());
        Assert.assertEquals(mainT, "Start Growing Your Business");

    }

    @Test
    public void categoryCount() throws InterruptedException {

        driver.get("https://elinebox.com/");
        List Elements = driver.findElements(By.cssSelector("div[class='swiper-slide free-mode-slide elb-home-category-swiper']"));

        // System.out.println(threeElements.size());
        Assert.assertEquals(Elements.size(), 19);

    }


}
