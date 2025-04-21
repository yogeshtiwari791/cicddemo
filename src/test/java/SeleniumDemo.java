import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo {

    public WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver=new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void testPageHeading() throws InterruptedException {
        String pageHeadingActual=driver.findElement(By.xpath("//h1")).getText();
        String pageHeadingExpected="Selenium automates browsers. That's it!";
        System.out.println(pageHeadingActual);
        Assert.assertEquals(pageHeadingActual,pageHeadingExpected);
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void testPageTitle() throws InterruptedException {
        String pageTitleActual=driver.getTitle();
        String pageTitleExpected="Selenium";
        System.out.println(pageTitleExpected);
        Assert.assertEquals(pageTitleActual,pageTitleExpected);
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
