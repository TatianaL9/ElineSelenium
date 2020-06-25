import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class clearCookies extends BaseClass {




        @Test
        public void cookiesClear() throws InterruptedException {
            driver.get("https://elinebox.com/");

            driver.manage().deleteAllCookies();
            Thread.sleep(5000);
            driver.get("https://elinebox.com/");


        }
    }
00
