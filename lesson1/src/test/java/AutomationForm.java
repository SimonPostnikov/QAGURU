import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationForm {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    String firstName = "Semyon",
            lastName = "Postnikov",
            userEmail = "postnikov.sn@mail.ru",
            userNumber = "1234567890",
            month = "May",
            year = "1993",
            subject = "Maths",
            currentAddress = "Peter",
            state = "NCR",
            city = "Del";
    @Test
    void automationTestForm() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(userNumber);

        //BirthDate
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Monday, May 10th, 1993']").click();
        //BirthDate

        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").scrollTo().click();


        $(".table-responsive").shouldHave(text(firstName + " " + lastName), text(userEmail),
                text("Male"), text(userNumber), text("10 " + month + "," + year), text(subject),
                text("Reading"), text(currentAddress),
                text(state +" "+ city));

    }
}


