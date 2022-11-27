package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1700x800";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() throws IOException, URISyntaxException {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Aleksandr");
        $("#lastName").setValue("Pushkin");
        $("#userEmail").setValue("apushkin@test.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label='Choose Thursday, November 29th, 1990']").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();


        $("#uploadPicture").uploadFile(download("https://demoqa.com/images/Test_Demo.jpg"));

        $("#currentAddress").setValue("bla bla bla");

        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").pressEnter();

        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text("Aleksandr Pushkin"),
                Condition.text("apushkin@test.com"),
                Condition.text("Male"),
                Condition.text("1234567890"),
                Condition.text("29 November,1990"),
                Condition.text("Maths"),
                Condition.text("Sports, Reading, Music"),
                Condition.text("Test_Demo.jpg"),
                Condition.text("bla bla bla"),
                Condition.text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
