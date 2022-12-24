package homeTask;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideRepoSearchTest {

    @Test
    void shouldFindExampleJUnit5AtSoftAssertionsPage() {
        // Открыть страницу selenide на github.com
        open("https://github.com/selenide/selenide");
        // Открыть страицу wiki проекта
        $("a#wiki-tab").click();
        // Убедиться, что в списке страниц есть страница SoftAssertions
        // Перейти на страницу SoftAssertions
        $(withTagAndText("button", "more page")).click();
        $$("li.Box-row a").findBy(text("SoftAssertions")).click();
        // Убедиться, что есть пример кода для JUnit5
//        $x("//h4[contains(text(), 'JUnit5')]/following-sibling::div//span[text()='Test']").should(exist);
        $$("h4").findBy(matchText("JUnit5")).sibling(1)
                .$("div").$(withTagAndText("span", "Test"));
    }
}
