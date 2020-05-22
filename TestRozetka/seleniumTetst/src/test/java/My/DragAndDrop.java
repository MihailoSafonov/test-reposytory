package My;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static com.oracle.jrockit.jfr.Transition.To;
import static com.oracle.jrockit.jfr.Transition.From;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DragAndDrop {
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
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement Bank=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement Account=driver.findElement(By.xpath("//*[@id='bank']/li"));
        WebElement Sales=driver.findElement(By.xpath("//*[@id='credit1']/a"));
        WebElement Account2=driver.findElement(By.xpath("//*[@id='loan']/li"));
        WebElement Monney5000=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement Amount=driver.findElement(By.xpath("//*[@id='amt7']/li"));
        WebElement Monney5_2=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement Ammount2=driver.findElement(By.xpath("//*[@id='amt8']/li"));

        Actions act=new Actions(driver);
        act.dragAndDrop(Bank, Account).build().perform();
        act.dragAndDrop(Sales, Account2).build().perform();
        act.dragAndDrop(Monney5000, Amount).build().perform();
        act.dragAndDrop(Monney5_2, Ammount2).build().perform();

            }
    @After
    public void stop() {
        //  driver.quit();
        driver = null;
    }
}
