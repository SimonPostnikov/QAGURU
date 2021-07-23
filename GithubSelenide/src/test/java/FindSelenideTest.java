import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void SoftAssertionsTes() {
        Configuration.headless = false;
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").$(byText("Wiki")).click();
        //$(".js-wiki-more-pages-link").scrollTo().click();
        //$$("#wiki-pages-box").findBy(text("SoftAssertions")).scrollTo().click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}