package ru.inno;

import java.util.Random;

public class Sensor {

    public static int humidity;

    public static int getHumidity() {
        Random random = new Random();
        humidity = random.nextInt(101);
        return humidity;
    }
}
