package Utilities;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static Faker faker = new Faker();

    public static String generateFixCharacters(int fixLength) {

        return faker.lorem().characters(fixLength, true, true);
    }

    public static String generateFixNumber(int fixDigits) {

        return String.valueOf(faker.number().digits(fixDigits));
    }

    public static String generateFirstName() {

        return faker.name().firstName();
    }

    public static String generateLastName() {

        return faker.name().lastName();
    }

    public static String generateNumber() {

        return faker.number().digits(8);
    }

    public static String username() {

        return faker.name().username();
    }

    public static String generateEmailAddress() {

        return faker.internet().emailAddress();
    }
}
