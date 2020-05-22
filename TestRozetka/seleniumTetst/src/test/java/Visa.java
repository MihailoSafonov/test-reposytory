//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//import javax.naming.ldap.LdapReferralException;
//
//import static org.junit.Assert.assertEquals;
//
//public class Visa {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @Before
//    public void start() {
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 30);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Actions actions = new Actions(driver);
//        driver.get("http://localhost:4200/login");
//        WebElement in = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("auth_email")));
//
//    }
//    @Test
//    public void Login() {
//       // WebElement in = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("auth_email")));
//        driver.findElement(By.id("auth_email")).sendKeys("m.safonov@hotmail.com");
//        driver.findElement(By.id("auth_password")).sendKeys("wwWW33#");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//       }
//        @Test
//        public void LogiNotValid() {
//
//            driver.findElement(By.id("auth_email")).sendKeys("m.2safonov@hotmail.com");
//            driver.findElement(By.id("auth_password")).sendKeys("wwWW33#");
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            assertEquals(driver.findElement(By.id("auth_email")), "auth_email");
//     }
//
//    @After
//    public void stop () {
//        // driver.quit();
//        driver = null;
//    }
//}
