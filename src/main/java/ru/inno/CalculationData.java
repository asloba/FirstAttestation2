package ru.inno;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class CalculationData {

    public static Date getLastIrrigationDate() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату последнего полива в формате dd.MM.yyyy: ");
        String usersDate = scanner.nextLine();
        if (usersDate.matches("^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})\\s*$")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = formatter.parse(usersDate);
            scanner.close();
            return date;
        } else {
            throw new Exception("Вы ввели некорректное значение даты. Обратите внимание на формат даты и перезапустите программу.");
        }
    }

    public LocalDate getLastIrrigationDateLocal() throws Exception {
        return getLastIrrigationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate calculateNextIrrigationDate(LocalDate lastIrrigationDate, int humidity) {
        LocalDate nextIrrigationDate = null;
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();

        int monthNumber = lastIrrigationDate.getMonthValue();
        if (monthNumber == 1 || monthNumber == 2 || monthNumber == 12) {
            nextIrrigationDate = lastIrrigationDate.plusMonths(1);
            System.out.println("Дата следующего полива кактуса: " + nextIrrigationDate);
        } else if (monthNumber > 5 && monthNumber < 9 && humidity < 30 && (!lastIrrigationDate.equals(today) || !lastIrrigationDate.equals(yesterday))) {
            nextIrrigationDate = LocalDate.now();
            System.out.println("Влажность воздуха: " + humidity + "\nДата следующего полива кактуса: " + nextIrrigationDate);
        } else if (monthNumber > 2 && monthNumber < 6 || monthNumber > 8 && monthNumber < 12) {
            nextIrrigationDate = lastIrrigationDate.plusWeeks(1);
            System.out.println("Дата следующего полива кактуса: " + nextIrrigationDate);
        } else
            System.out.println("Влажность воздуха: " + humidity + "\nПоливать кактус не нужно");
        return nextIrrigationDate;
    }
}
