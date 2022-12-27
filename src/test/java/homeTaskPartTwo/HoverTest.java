package homeTaskPartTwo;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoverTest {

    @Test
    void enterprisePageTitleTest() {
        // открыть github.com
        open("https://github.com");
        // навести мышку на Solutions, кликнуть по ней
        $(withTagAndText("button", "Solutions")).hover();
        $("a.HeaderMenu-dropdown-link[href$='enterprise']").shouldBe(visible).click();
        // проверить, что есть заголовок - Build like the best
        $(withTagAndText("h1", "Build like the best")).should(exist);
        // проверить, что url ожидаемый
        assertEquals("https://github.com/enterprise", WebDriverRunner.url());
    }
}
