package My;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.IRObjectOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class iframes {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start()   {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();

    }
    @Test
    public void myFirstTest() throws AWTException {
        Actions actions = new Actions(driver);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/index.php");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Primis Player Videos']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src=\"about:blank\"]")));
        driver.findElement(By.xpath("//div[@id='playBtn']")).click();

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Flow Close Button']")));
        WebElement target= driver.findElement(By.xpath("//div[@id='closeBtn']"));
        actions.moveToElement(target).perform();

        driver.switchTo().defaultContent();
        wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Primis Player Videos']"))));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='about:blank']")));
        WebElement pauseButton = driver.findElement(By.xpath("//div[@id='pauseBtn']"));

        assertFalse(pauseButton.isDisplayed());
        WebElement iframeContainer = driver.findElement(By.xpath("//*[@id='videoContainerDiv']"));
        actions.moveToElement(iframeContainer).perform();
        assertTrue(pauseButton.isDisplayed());

    }
    @After
    public void stop() {
       //  driver.quit();
        driver = null;
}}
