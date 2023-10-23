package com.mna.app.base.util;

import java.util.Random;

public class EmployeeUtils {

    private static final String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "William", "Olivia", "James", "Sophia", "Daniel", "Isabella"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Taylor", "Anderson", "Harris", "Davis", "Miller", "Jones", "Clark"};

    public static String generateRandomName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

}
