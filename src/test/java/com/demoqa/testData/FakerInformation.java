package com.demoqa.testData;

import com.github.javafaker.Faker;

import pages.components.Month;
import java.util.Locale;

public class FakerInformation {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static String
        name = faker.name().firstName(),
        surname = faker.name().lastName(),
        email = faker.internet().emailAddress(),
        gender = faker.demographic().sex(),
        number = faker.phoneNumber().subscriberNumber(10),
        day = String.valueOf(faker.number().numberBetween(10,20)),
        month = String.valueOf(Month.getRandomMonth()),
        year = String.valueOf(faker.number().numberBetween(1950, 2000)),
        subject = "English",
        hobbies = "Reading",
        picturePath = "img/1.png",
        picture = "1.png",
        address = faker.address().fullAddress(),
        state = "NCR",
        city = "Delhi",
        birthDay = day + " " + month + "," + year;
}
