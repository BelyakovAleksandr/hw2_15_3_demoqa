package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.testData.FakerInformation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;

import static com.demoqa.testData.FakerInformation.email;

public class RegistationFormTest {
    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1720x1440";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {
        registrationForm.openPage()
                .setFirstName(FakerInformation.name)
                .setLastName(FakerInformation.surname)
                .setEmail(email)
                .setGender(FakerInformation.gender)
                .setNumber(FakerInformation.number)
                .setBirthDate(FakerInformation.day, FakerInformation.month, FakerInformation.year)
                .setSubject(FakerInformation.subject)
                .setHobbies(FakerInformation.hobbies)
                .setPicture(FakerInformation.picturePath)
                .setAddress(FakerInformation.address)
                .setLocation(FakerInformation.state, FakerInformation.city)
                .clickSubmit();
        registrationForm.checkResult()
                .checkResult("Student Name", FakerInformation.name + " " + FakerInformation.surname)
                .checkResult("Student Email", FakerInformation.email)
                .checkResult("Gender", FakerInformation.gender)
                .checkResult("Mobile", FakerInformation.number)
                .checkResult("Date of Birth", FakerInformation.birthDay)
                .checkResult("Subjects", FakerInformation.subject)
                .checkResult("Hobbies", FakerInformation.hobbies)
                .checkResult("Picture", FakerInformation.picture)
                .checkResult("Address", FakerInformation.address)
                .checkResult("State and City", FakerInformation.state + " " + FakerInformation.city);
    }
}