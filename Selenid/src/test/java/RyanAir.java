import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RyanAir {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @Test
    public void ByTicetsRyanAir() {
        open("https://www.ryanair.com/ua/uk");
        $(By.id("input-button__departure")).clear();
        $(By.id("input-button__departure")).setValue("Vienna");
        $(By.id("input-button__destination")).clear();
        $(By.id("input-button__destination")).setValue("Kyiv");
        $(By.xpath("//span[text()=' Київ-Бориспіль ']")).click();
        $(By.xpath("//div[text()=' черв. ']")).click();
        $(By.xpath("//div[@data-id='2020-06-08']")).click();
        $(By.xpath("//div[@data-id='2020-06-11']")).click();
        $(By.xpath("(//div[@class='counter']//div)[4]")).click();
        $(By.xpath("//button[@data-ref='flight-search-widget__cta']")).click();
        $(By.xpath("//h4[text()='Vienna']")).shouldHave(text("Vienna"));
        $(By.xpath("//h4[text()='Київ-Бориспіль']")).shouldHave(text("Київ-Бориспіль"));// Само подождёт, пока у элемента появится нужный текст
        $(By.xpath("//div[text()='8 черв.']")).shouldHave(text("8 черв"));
        $(By.xpath("//span[text()=' - 11 черв.']")).shouldHave(text("11 черв"));
    }

}
