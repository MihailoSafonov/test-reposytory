import com.sun.corba.se.impl.interceptors.CDREncapsCodec;
import com.sun.rowset.JdbcRowSetResourceBundle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import org.openqa.selenium.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Rozetka2 {

    private WebDriver driver;
    private WebDriverWait wait;

       @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

        @Test
        public void manufacturerCheckBox () throws Exception {
            Actions actions = new Actions(driver);
            driver.get("https://rozetka.com.ua/ua/");
            wait.until(presenceOfElementLocated(By.name("search")));
            driver.findElement(By.name("search")).click();
            driver.findElement(By.name("search")).sendKeys("Samsung");
            wait.until(presenceOfElementLocated(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
            actions.sendKeys(Keys.ESCAPE);
            driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")).click();
            wait.until(presenceOfElementLocated(By.xpath("(//li[@class='m-cat-subl-i']//a)[3]['планшеты']")));
            driver.findElement(By.xpath("(//li[@class='m-cat-subl-i']//a)[3]['планшеты']")).click();
            wait.until(presenceOfElementLocated(By.xpath("//label[@for='Acer']")));
            driver.findElement(By.xpath("//label[@for='Acer']")).click();
            driver.findElement(By.xpath("//label[@for='Asus']")).click();
            //assertTrue(rozetkaFiltersPage.verifyFilterManufacturer("asus", "samsung", "acer"));
            List<WebElement> allLable = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
            for (WebElement element : allLable) {
                String titleProduct = element.getText().toLowerCase();
                if (!(titleProduct.contains("asus") || titleProduct.contains("samsung") || titleProduct.contains("acer"))) {
                    throw new Exception("No Acer or Samsung or Asus");
                }
            }
        }

            @Test
            public void piceCheck() throws Exception {
                    driver.get("https://rozetka.com.ua/ua/");
                    wait.until(presenceOfElementLocated(By.name("search")));
                    driver.findElement(By.name("search")).click();
                    driver.findElement(By.name("search")).sendKeys("Samsung");
                    wait.until(presenceOfElementLocated(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
                    //actions.sendKeys(Keys.ESCAPE);
                    driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")).click();
                    wait.until(presenceOfElementLocated(By.xpath("(//li[@class='m-cat-subl-i']//a)[3]['планшеты']")));
                    driver.findElement(By.xpath("(//li[@class='m-cat-subl-i']//a)[3]['планшеты']")).click();
                    wait.until(presenceOfElementLocated(By.xpath("//input[@formcontrolname='min']")));
                    driver.findElement(By.xpath("//input[@formcontrolname='min']")).clear();
                    driver.findElement(By.xpath("//input[@formcontrolname='min']")).sendKeys("5000");
                    driver.findElement(By.xpath("//input[@formcontrolname='max']")).clear();
                    driver.findElement(By.xpath("//input[@formcontrolname='max']")).sendKeys("15000");
                    driver.findElement(By.xpath("//button[@type='submit'][@class='button button_color_gray button_size_small slider-filter__button']")).click();
                    //  assertTrue(rozetkaFiltersPage.verifyPriceFilter(5000, 15000));
                    List<WebElement> allPrice = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
                    for (WebElement webElement : allPrice) {
                        int price = Integer.parseInt(webElement.getText().replaceAll(" ", ""));
                        if (!(price > 5000 && price < 15000)) {
                            throw new Exception("Selected products do not fall within the range of selected prices");
                        }
                    }
                }
            @Test
            public void myFiltr() throws Exception {
                Actions actions = new Actions(driver);
                driver.get("https://rozetka.com.ua/ua/");
                wait.until(presenceOfElementLocated(By.name("search")));
                driver.findElement(By.name("search")).click();
                driver.findElement(By.name("search")).sendKeys("Samsung");
                wait.until(presenceOfElementLocated(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
                actions.sendKeys(Keys.ESCAPE);
                driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")).click();
                wait.until(presenceOfElementLocated(By.xpath("(//li[@class='m-cat-subl-i']//a)[3]['планшеты']")));
                driver.findElement(By.xpath("(//li[@class='m-cat-subl-i']//a)[3]['планшеты']")).click();
                wait.until(presenceOfElementLocated(By.xpath("//label[@for='Acer']")));
                driver.findElement(By.xpath("//label[@for='9\" - 10\"']")).click();
                driver.findElement(By.xpath("//label[@for='4 ГБ']")).click();
                driver.findElement(By.xpath("//label[@for='Android 10.x']")).click();
                WebElement goods = driver.findElement(By.xpath("//li[@class='catalog-grid__cell catalog-grid__cell_type_slim']"));
                actions.moveToElement(goods).perform();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<WebElement> goodWithThreeFilters = driver.findElements(By.xpath("//p[@class='goods-tile__description goods-tile__description_type_text']"));
                assertTrue(verifyThreeFilters(goodWithThreeFilters));
       }

            private boolean verifyThreeFilters(List<WebElement> elem) throws Exception {
                for (WebElement webElement : elem) {
                    if (webElement.getText().contains("Android 10.0 (Q)") && webElement.getText().contains("10.4") && webElement.getText().contains("4 ГБ")) {
                    }
                  }
                return true;
       }
            protected void safeAlertDissmiss () {
                    try {
                        driver.switchTo().alert().dismiss();
                    } catch (NoAlertPresentException e) {
                        // ничего не делаем, алерта итак нет
                    }
                }
            }


