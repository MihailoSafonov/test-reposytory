import java.awt.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Rozetka {
        private WebDriver driver;
        private WebDriverWait wait;
         int positionFirstMonitor = 0;
         int searchedPriceFirstMonitor = 0;
         int positionSecondMonitor =0;
        @Before
        public void start() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
            driver.manage().window().maximize();
        }
        @Test
        public void myFirstTest() throws AWTException, InterruptedException {
            Actions actions = new Actions(driver);
            driver.get("https://rozetka.com.ua/ua/");
            WebElement we = driver.findElement(By.xpath("(//a[@class='menu-categories__link'])[1]"));
            actions.moveToElement(we).build().perform();
            wait.until((presenceOfElementLocated(By.linkText("Все категории"))));
            driver.findElement(By.xpath("//a[@class='menu__link' and text()=' Мониторы ']")).click();
            wait.until((presenceOfElementLocated(By.xpath("//h1[@class='catalog-heading']"))));

            List<WebElement> price = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
            for (int i = 0; i < price.size(); i++) {
                int tempPrice = parseInt(price.get(i).getText().replaceAll(" ", ""));
                if (tempPrice < 3000) {
                    positionFirstMonitor = i + 1;
                    searchedPriceFirstMonitor = tempPrice;
                    break;
                }
            }
            WebElement firstMonitor = driver.findElement(By.xpath("//li[@class='catalog-grid__cell catalog-grid__cell_type_slim'][" + positionFirstMonitor + "]//a[@class='goods-tile__picture']/img"));
            scrollToElement(firstMonitor);
            firstMonitor.click();
            wait.until(( presenceOfElementLocated(By.xpath("//ul[@class='product-actions']")) ));

            //4. Add monitor to comparison. Verify icon (1) appears in header close to comparison image (scales). Remember price, name
            WebElement productActions = driver.findElement(By.xpath("//ul[@class='product-actions']"));
            scrollToElement(productActions);
            WebElement compareButtonForFirstMonitor = driver.findElement(By.xpath("//button[@class='compare-button']"));
            compareButtonForFirstMonitor.click();
            String priceFirstMonitor = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']")).getText().substring(0, 4);
            String nameFirstMonitor = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();
            WebElement userLink = driver.findElement(By.xpath("//a[@class='header-topline__user-link link-dashed']"));
            scrollToElement(userLink);
            assertEquals(driver.findElement(By.xpath("//span[@class='header-actions__button-counter']")).getText(), "1");

            //5. Click back button in browser
            driver.navigate().back();
            wait.until(( presenceOfElementLocated(By.xpath("//h1[@class='catalog-heading']")) ));

            //6. Find first monitor which price is less then first monitor. Click on image of found monitor. Wait for page to load
            List<WebElement> price2 = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
            for (int i = 0; i < price2.size(); i++) {
                int tempPrice = parseInt(price2.get(i).getText().replaceAll(" ", ""));
                if (tempPrice < searchedPriceFirstMonitor) {
                    positionSecondMonitor = i + 1;
                    break;
                }
            }
            WebElement secondMonitor = driver.findElement(By.xpath("//li[@class='catalog-grid__cell catalog-grid__cell_type_slim'][" + positionSecondMonitor + "]//a[@class='goods-tile__picture']/img"));
            secondMonitor.click();
            wait.until(( presenceOfElementLocated(By.xpath("//ul[@class='product-actions']")) ));

            //7. Add second monitor to comparison. Verify icon (2) appears in header close to comparison image (scales). Remember price, name
            WebElement compareButtonForSecondMonitor = driver.findElement(By.xpath("//button[@class='compare-button']"));
            compareButtonForSecondMonitor.click();
            String priceSecondMonitor = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']")).getText().substring(0, 4);
            String nameSecondMonitor = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();
            scrollToElement(userLink);
            assertEquals(driver.findElement(By.xpath("//span[@class='header-actions__button-counter']")).getText(), "2");

            //8. Click on comparison image in header. Click on "Мониторы (2)". Wait for page to load
            WebElement baseCompareButton = driver.findElement(By.xpath("//a[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active']"));
            hoverToElement(baseCompareButton);
            WebElement stringTwoMonitors = driver.findElement(By.linkText("Мониторы (2)"));
            stringTwoMonitors.click();
            wait.until(( presenceOfElementLocated(By.xpath("//a[text()='Очистить все']")) ));

            //9. Verify that in comparison you have just 2 monitors
            List<WebElement> countComparedGoods = driver.findElements(By.xpath("//div[@class='comparison-t-head-cell valigned-top']"));
            assertEquals(2, countComparedGoods.size());

            //10. Verify that names are correct (equal to names which you stored in step4 and step7)
            assertEquals(nameFirstMonitor, driver.findElement(By.xpath("//a[@class='comparison-g-title g-title novisited'][1]")).getText());
            assertEquals(nameSecondMonitor, driver.findElement(By.xpath("//a[normalize-space(text())='Монитор 21.5\" BenQ GW2283 (9H.LHLLA.TBE)']")).getText());

            //11. Verify that prices are correct (equal to prices which you stored in step4 and step7)
            assertEquals(priceFirstMonitor.trim(), driver.findElement(By.xpath("//div[normalize-space(text())='2 899']")).getText().substring(0, 4).trim());
            assertEquals(priceSecondMonitor.trim(), driver.findElement(By.xpath("//div[normalize-space(text())='2 499']")).getText().substring(0, 4).trim());
        }

    private void hoverToElement(WebElement elem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void scrollToElement(WebElement elem) {
        ( (JavascriptExecutor) driver ).executeScript("arguments[0].scrollIntoView(true);", elem);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

                @After
        public void stop() {
            // driver.quit();
            driver = null;
        }
}

