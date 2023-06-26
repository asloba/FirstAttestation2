package ru.inno;

import java.time.LocalDate;

import static ru.inno.CalculationData.calculateNextIrrigationDate;

public class IrrigationCalcApp {

    public static void main(String[] args) throws Exception {

        CalculationData calculationData = new CalculationData();
        LocalDate lastIrrigationDateLocal = calculationData.getLastIrrigationDateLocal();
        int humidity = Sensor.getHumidity();
        calculateNextIrrigationDate(lastIrrigationDateLocal, humidity);
    }
}
