import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Selenide1test {
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    @DisplayName("Find <Junit5>")
    void testGit() {
//Откройте страницу Selenide в Github
        open ("https://github.com/selenide/selenide");
// Перейдите в раздел Wiki проекта
        $(By.id("wiki-tab")).click();
// Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
// - Откройте страницу SoftAssertions
        $("#wiki-pages-filter").sendKeys("soft");
        $(byText("SoftAssertions")).click();
// проверьте что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4")
                .shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
