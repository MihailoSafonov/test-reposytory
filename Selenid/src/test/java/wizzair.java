import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class wizzair {
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @Test
    public void ByTicetsWizzair() {
        Configuration.timeout=12000;
        open("https://wizzair.com/#/");
        $(By.id("search-departure-station")).setValue("Vienna");
        $(By.xpath("//mark[text()[normalize-space()='Vienna']]")).click();
        $(By.id("search-arrival-station")).setValue("Kyiv");
        $(By.xpath("//mark[text()='Kyiv']")).click();
        $(By.className("pika-next")).click();
        $(By.xpath("//button[@data-pika-year='2020'][@data-pika-month='5'][@data-pika-day='8']")).click();
        $(By.xpath("//button[@data-pika-year='2020'][@data-pika-month='5'][@data-pika-day='8']")).click();
        $(By.xpath("//button[@data-pika-year='2020'][@data-pika-month='5'][@data-pika-day='11']")).click();
        $(By.xpath("(//button[text()=' OK '])[1]")).click();
        $(By.id("search-passenger")).click();
        $(By.xpath("(//button[@class='stepper__button stepper__button--add'])[1]")).click();
        $(By.xpath("(//button[text()=' OK '])[2]")).click();
        $(By.xpath("//span[text()='Search']")).click();
        switchTo().window(1);
        $(By.xpath("//html/body/div[2]/div/main/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]/div/div/div[1]/div[1]/time")).shouldHave(text(" Mon, 8 Jun 2020 "));
        $(By.xpath("/html/body/div[2]/div/main/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[2]/div/div/div[1]/div[1]/time")).shouldHave(text("  Thu, 11 Jun 2020  "));
        $(By.xpath("//html/body/div[2]/div/main/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/span[2]")).shouldHave(text("Vienna"));
        $(By.xpath("//html/body/div[2]/div/main/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/span[2]")).shouldHave(text("Kyiv - Zhulyany"));
    }
}
