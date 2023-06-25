package ru.inno;

import java.util.Random;

public class Sensor {

    public static int getHumidity() {
        Random random = new Random();
        return random.nextInt(101);
    }
}
