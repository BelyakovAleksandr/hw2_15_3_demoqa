package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomData {

    public static String shtat;

    public static String getRandomMonth() {
        List<String> months = Arrays.asList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
        return months.get(new Random().nextInt(months.size()));
    }

    public static String getRandomSubjects() {
        List<String> subjects = Arrays.asList(
                "Maths",
                "Chemistry",
                "Computer Science",
                "Commerce",
                "Economics");
        return subjects.get(new Random().nextInt(subjects.size()));
    }

    public static String getRandomHobbies() {
        List<String> hobbies = Arrays.asList(
                "Sports",
                "Reading",
                "Music");
        return hobbies.get(new Random().nextInt(hobbies.size()));
    }

    public static String getRandomState() {
        List<String> state = Arrays.asList(
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan");
        shtat = state.get(new Random().nextInt(state.size()));
        return shtat;
    }

    public static String getRandomCity() {
        List<String> city;
        switch (shtat) {
            case  ("NCR"):
                city = Arrays.asList(
                        "Delhi",
                        "Gurgaon",
                        "Noida");
                return city.get(new Random().nextInt(city.size()));
            case ("Uttar Pradesh"):
                city = Arrays.asList(
                        "Agra",
                        "Lucknow",
                        "Merrut");
                return city.get(new Random().nextInt(city.size()));
            case ("Haryana"):
                city = Arrays.asList(
                        "Karnal",
                        "Panipat");
                return city.get(new Random().nextInt(city.size()));
            case ("Rajasthan"):
                city = Arrays.asList(
                        "Jaipur",
                        "Jaiselmer");
                return city.get(new Random().nextInt(city.size()));
        }
        return null;
    }
}
