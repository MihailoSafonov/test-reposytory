import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class Authorization {
    private WebDriver driver;
    private WebDriverWait wait;
    By userIDInput = By.name("uid");
    By passwordInput = By.name("password");
    By logginButton = By.name("btnLogin");
    By logout = By.xpath("//a[@href='Logout.php']");
    String userID = "1303";
    String password = "Guru99";

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/index.php");
              }

    @Test
    public void autorizationValid() {
        driver.findElement(userIDInput).sendKeys(userID);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(logginButton).click();
        String url=driver.getCurrentUrl();
        assertEquals("http://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php", url);

    }
    @Test
    public void autorizationNoId() {
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(logginButton).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("User or Password is not valid", alertText);
    }
    @Test
    public void autorizationNoPass() {
        driver.findElement(userIDInput).sendKeys(userID);
        driver.findElement(logginButton).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("User or Password is not valid", alertText);
    }
    @Test
    public void autorizationWrongPass() {
        driver.findElement(userIDInput).sendKeys(userID);
        driver.findElement(passwordInput).sendKeys("2345434");
        driver.findElement(logginButton).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("User or Password is not valid", alertText);
    }
    @Test
    public void autorizationWrongLogin() {
        driver.findElement(userIDInput).sendKeys("234234a");
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(logginButton).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("User or Password is not valid", alertText);
    }
        @Test
        public void autorizationLogAndPassrevert() {
            driver.findElement(userIDInput).sendKeys(password);
            driver.findElement(passwordInput).sendKeys(userID);
            driver.findElement(logginButton).click();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals("User or Password is not valid", alertText);
    }
        @Test
          public void autorizationLogout() {
             driver.findElement(userIDInput).sendKeys(userID);
             driver.findElement(passwordInput).sendKeys(password);
             driver.findElement(logginButton).click();
             wait.until(ExpectedConditions.elementToBeClickable(logout));
             driver.findElement(logout).click();
             Alert alert = driver.switchTo().alert();
             String alertText = alert.getText();
             assertEquals("You Have Succesfully Logged Out!!", alertText);

            }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}