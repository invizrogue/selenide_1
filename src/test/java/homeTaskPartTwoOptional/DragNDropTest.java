package homeTaskPartTwoOptional;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.withTagAndText;

public class DragNDropTest {

    @Test
    void dragNDropTest() {
        // открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // проверить положение прямоугольников A и B относительно друг друга
        $x("//header[text()='A']/following::header[text()='B']").shouldBe(visible);
        $x("//header[text()='B']/following::header[text()='A']").shouldNotBe(visible);
        // перетянуть прямоугольник A на прямоугольник B
//        actions().dragAndDrop($("#column-a"), $("#column-b")).perform(); // не отработало
//        actions().moveToElement($(withTagAndText("header", "A"))).clickAndHold()
//                .moveToElement($(withTagAndText("header", "B"))).release().perform(); // не отработало
        $("#column-a").dragAndDropTo("#column-b");
//        // проверить, что положение изменилось на обратное
        $x("//header[text()='A']/following::header[text()='B']").shouldNotBe(visible);
        $x("//header[text()='B']/following::header[text()='A']").shouldBe(visible);
    }
}
