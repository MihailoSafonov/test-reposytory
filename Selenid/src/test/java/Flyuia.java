import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Flyuia {
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @Test
    public void ByTicetsWizzair() {
        Configuration.timeout = 8000;
        open("https://www.flyuia.com/ua/ua/home");
        $(By.xpath("//input[@placeholder='Відправлення']")).setValue("Vienna").sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
        $(By.xpath("//input[@placeholder='Прибуття']")).setValue("Kyiv").sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
        $(By.xpath("(//input[@placeholder='дд.мм.pppp']/following-sibling::div)[1]")).click();
        $(By.className("obe-sw-icon-navigate_next")).click();
        $(By.className("obe-sw-icon-navigate_next")).click();
        $(By.xpath("//button[text()=' 8 ']")).click();
        $(By.xpath("(//div[@class='input-infix fx-flex-fill']//div)[2]")).click();
        $(By.className("obe-sw-icon-navigate_next")).click();
        $(By.className("obe-sw-icon-navigate_next")).click();
        $(By.xpath("//button[text()=' 11 ']")).click();
        $(By.xpath("//div[text()=' 1 Пасажир ']")).click();
        $(By.xpath("(//button[contains(@class,'set-val-btn fx-row__center__center')])[2]")).click();
        $(By.id("SEARCH_WIDGET_FORM_BUTTONS_SEARCH_FLIGHTS")).click();
        $(By.xpath("//div[text()='Варіанти вильоту: Vienna - Kyiv']")).shouldBe(visible);
        $(By.xpath("//div[text()='Варіанти зворотного перельоту: Kyiv - Vienna']")).shouldBe(visible);
        $(By.xpath("//div[text()='Пн, 08 Черв. - Чт, 11 Черв.']")).shouldBe(visible);

    }
}
