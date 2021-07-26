import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void softAssertionsTes() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").$(byText("Wiki")).click();
        $(".js-wiki-more-pages-link").scrollTo().click();
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        sleep(5000);
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}