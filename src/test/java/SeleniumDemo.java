import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
    }
    @Test(priority = 2)
    public void testPageTitle() throws InterruptedException {
        String pageTitleActual=driver.getTitle();
        String pageTitleExpected="Selenium";
        System.out.println(pageTitleExpected);
        Assert.assertEquals(pageTitleActual,pageTitleExpected);
    }
    @Test(priority = 3)
    public void navigateToDownloads() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='main_navbar']/ul/li[2]")).click();
        Thread.sleep(3000);
        List<WebElement> languages=driver.findElements(By.xpath("//main[@role='main']/div[3]/div/div/div[2]/p[1]"));
        for(WebElement lang:languages){
            System.out.println(lang.getText());
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
