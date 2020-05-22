//package My;
//
//        import org.junit.After;
//        import org.junit.Before;
//        import org.junit.Test;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.chrome.ChromeDriver;
//        import org.openqa.selenium.interactions.Action;
//        import org.openqa.selenium.support.ui.ExpectedConditions;
//        import org.openqa.selenium.support.ui.WebDriverWait;
//        import org.openqa.selenium.interactions.Actions;
//
//        import java.time.Duration;
//        import java.util.concurrent.TimeUnit;
//
//public class FirstTest {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @Before
//    public void start() {
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }
//    @Test
//    public void myFirstTest() {
//        Actions actions = new Actions(driver);
//        driver.get("https://rozetka.com.ua/");
//        WebElement ele=driver.findElement(By.cssSelector(".menu-categories_type_main > .menu-categories__item:nth-child(1) > .menu-categories__link"));
//        actions.moveToElement(ele).perform();
//
//        driver.findElement(By.xpath("//a[contains(@href, 'https://hard.rozetka.com.ua/ua/monitors/c80089/')]")).click();
//
//    }
//    @After
//    public void stop () {
//        // driver.quit();
//        driver = null;
//    }
//}
//
