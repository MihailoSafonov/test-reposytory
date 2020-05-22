package My;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static jdk.nashorn.internal.objects.Global.print;
import static org.junit.Assert.assertEquals;

public class Cookies {
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
        driver.get("http://demo.guru99.C:\\Users\\Mykhailo\\IdeaProjects\\TestRozetka\\seleniumTetst\\src\\test\\java\\Mycom/Agile_Project/Agi_V1/index.php/");
        Cookie cookie = new Cookie("foo", "bar");
        driver.manage().addCookie(cookie);
        driver.navigate().to("http://demo.guru99.com/Agile_Project/Agi_V1/index.php/");

        driver.findElement(By.name("uid")).click();
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
        System.out.println(driver.manage().getCookies());
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    //  assertEquals(driver.findElement(By.xpath("кнопка выйти")).getText(),"выйти");

    }
    @After
    public void stop() {
        // driver.quit();
        driver = null;
    }
}
