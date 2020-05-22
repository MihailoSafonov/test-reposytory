package My;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.After;
import org.junit.Assert;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Robot;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static javafx.scene.input.KeyCode.V;

public class GmailTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

    }

    @Test
    public void myFirstTest() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        driver.get("https://mail.google.com/");
        driver.findElement(By.name("identifier")).sendKeys("mykhailoSafonov@gmail.com");
        driver.findElement(By.className("CwaK9")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("8moooo7jii9");
        driver.findElement(By.className("CwaK9")).click();
        WebElement buttonWrite = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='z0']//div[1]")));
        driver.findElement(By.xpath("//div[@class='z0']//div[1]")).click();
        WebElement adress = wait.until(ExpectedConditions.elementToBeClickable(By.name("to")));
        driver.findElement(By.name("to")).sendKeys("mykhailoSafonov@gmail.com");
        driver.findElement(By.className("G-asx")).click();
        driver.findElement(By.name("subjectbox")).click();
        driver.findElement(By.name("subjectbox")).sendKeys("This is the test mail");
        driver.findElement(By.xpath("//div[@role='textbox']")).click();
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test text for mail");
        driver.findElement(By.xpath("//div[contains(@class,'a1 aaA')]")).click();
        WebElement upload = driver.findElement(By.xpath("//div[contains(@class,'a1 aaA')]"));
        StringSelection ss = new StringSelection("C:\\windows-version.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WebElement send = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='dC']//div)[1]")));
        driver.findElement(By.xpath(("(//div[@class='dC']//div)[1]"))).click();
      //  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='This is the test mail']"))));
    //    driver.findElement(By.xpath("//span[text()='This is the test mail']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='bqe']"));
        elements.get(1).click();
        assertEquals(driver.findElement(By.xpath("//h2[text()='This is the test mail']")).getText(),"This is the test mail");
        assertEquals(driver.findElement(By.xpath("//div[text()='test text for mail']")).getText(),"test text for mail");
        //driver.findElement(By.xpath("(//span[@class='aV3 zzV0ie'][text()='windows-version.txt']")).click();
        assertEquals(driver.findElement(By.id("(//span[@class='aV3 zzV0ie'][text()='windows-version.txt']")).getText(),"windows-version.txt");
    }
        @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}