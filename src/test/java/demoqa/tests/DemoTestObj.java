package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import demoqa.pages.RegistrationFormPage;

public class DemoTestObj {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void simpleTest(){
        registrationFormPage
                .openPage()
                .setFirstName("Egor")
                .setLastName("Petrov")
                .setEmail("Egor@mail.ru")
                .setGenderWrapper("Male")
                .setPhoneNumber("1234567890")
                .setAddress("123 123")
                .setBirthdate("1995","April","12")
                .setHobbies("Sports")
                .uploadPicture("src/test/resources/K5XLWdiTxVs.jpg")
                .setSubjects("Chemistry")
                .setState("Haryana")
                .setCity("Karnal")
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name", "Egor Petrov")
                .checkResult("Student Email", "Egor@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth","12 April,1995")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Address", "123 123")
                .checkResult("Picture", "K5XLWdiTxVs.jpg")
                .checkResult("State and City", "Haryana Karnal");

    }
}
