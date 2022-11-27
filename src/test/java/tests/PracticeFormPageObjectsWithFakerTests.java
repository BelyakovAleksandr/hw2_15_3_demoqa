package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPageObjectsPage;
import utils.RandomData;

import java.io.IOException;
import java.net.URISyntaxException;

public class PracticeFormPageObjectsWithFakerTests {

    PracticeFormPageObjectsPage practiceFormPageObjectsPage = new PracticeFormPageObjectsPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String numberPhone = faker.phoneNumber().subscriberNumber(10);
    String day = String.valueOf(faker.number().numberBetween(1, 31));
    String month = RandomData.getRandomMonth();
    String year = String.valueOf(faker.number().numberBetween(1975, 2008));
    String subjects = RandomData.getRandomSubjects();
    String hobbies = RandomData.getRandomHobbies();

    String address = faker.address().fullAddress();
    String state = RandomData.getRandomState();
    String city = RandomData.getRandomCity();

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1700x800";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() throws IOException, URISyntaxException {

        practiceFormPageObjectsPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(numberPhone)
                .setBirthdate(year,month,day)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture("https://demoqa.com/images/Test_Demo.jpg")
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit()

                .checkResultsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", numberPhone)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "Test_Demo.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city)
                .closeResultModal();
    }

    @Test
    void fillFormWithMinimumDataTest() {
        practiceFormPageObjectsPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(numberPhone)
                .clickSubmit()

                .checkResultsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", numberPhone)
                .closeResultModal();
    }
}
