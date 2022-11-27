package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPageObjectsPage;

import java.io.IOException;
import java.net.URISyntaxException;

public class PracticeFormPageObjectsTests {

    PracticeFormPageObjectsPage practiceFormPageObjectsPage = new PracticeFormPageObjectsPage();

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1700x800";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() throws IOException, URISyntaxException {
        practiceFormPageObjectsPage.openPage()
                .setFirstName("Egor")
                .setLastName("Krid")
                .setEmail("ekrid@test.com")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthdate("1990","November","29")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture("https://demoqa.com/images/Test_Demo.jpg")
                .setAddress("Orenburg")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit()

                .checkResultsVisible()
                .checkResult("Student Name", "Egor Krid")
                .checkResult("Student Email", "ekrid@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "29 November,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "Test_Demo.jpg")
                .checkResult("Address", "Orenburg")
                .checkResult("State and City", "Haryana Karnal")
                .closeResultModal();
    }

    @Test
    void fillFormWithMinimumDataTest() {
        practiceFormPageObjectsPage.openPage()
                .setFirstName("Egor")
                .setLastName("Krid")
                .setGender("Male")
                .setNumber("1234567890")
                .clickSubmit()

                .checkResultsVisible()
                .checkResult("Student Name", "Egor Krid")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .closeResultModal();
    }
}
