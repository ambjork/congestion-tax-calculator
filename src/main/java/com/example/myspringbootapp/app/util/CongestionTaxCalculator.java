package com.example.myspringbootapp.app.util;

import com.example.myspringbootapp.app.model.AbstractVehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CongestionTaxCalculator {

       /*public static int getTax(AbstractVehicle vehicle) {
        // TODO: gör en lista med datum och addera totalFee per datum.
        List<LocalDateTime> dates = vehicle.getPassageTimes();

        LocalDateTime intervalStart = dates.get(0);
        int totalFee = 0;

        for (LocalDateTime date : dates) {
            int nextFee = GetTollFee(date);
            int tempFee = GetTollFee(intervalStart);

            long minutes = ChronoUnit.MINUTES.between(date, intervalStart);

            if (minutes <= 60) {
                if (totalFee > 0) totalFee -= tempFee;
                if (nextFee >= tempFee) tempFee = nextFee;
                totalFee += tempFee;
            } else {
                totalFee += nextFee;
            }
        }                
      
        if (totalFee > 60) totalFee = 60;
        return totalFee;
    }*/
    public static int getTax(AbstractVehicle vehicle) {
        Map<LocalDate, Integer> totalFeePerDate = calculateTotalFeePerDate(vehicle);
        Integer totalFee = 0;
        for (Map.Entry<LocalDate, Integer> entry : totalFeePerDate.entrySet()) {
           totalFee += entry.getValue();
        }

        return totalFee;
    }

    public static Map<LocalDate, Integer> calculateTotalFeePerDate(AbstractVehicle vehicle) {
        List<LocalDateTime> dates = vehicle.getPassageTimes();
        Map<LocalDate, Integer> totalFeePerDate = new HashMap<>();

        for (LocalDateTime date : dates) {
            LocalDate localDate = date.toLocalDate();
            int nextFee = GetTollFee(date);
            // int tempFee = GetTollFee(date);

            if (totalFeePerDate.containsKey(localDate)) {
                int existingTotalFee = totalFeePerDate.get(localDate);
                totalFeePerDate.put(localDate, existingTotalFee + nextFee);
            } else {
                totalFeePerDate.put(localDate, nextFee);
            }
        }

        // Ensure total fee doesn't exceed 60
        totalFeePerDate.replaceAll((date, fee) -> Math.min(fee, 60));
        return totalFeePerDate;
    }


    public static int GetTollFee(LocalDateTime date)
    {
        if (IsTollFreeDate(date)) return 0;

        LocalTime pointOfTime = LocalTime.of(date.getHour(), date.getMinute());

        // 06:00–06:29	SEK 8
        if (within(pointOfTime, LocalTime.of(6, 0), LocalTime.of(6,29)))
            return 8;

        // 06:30–06:59	SEK 13
        else if (within(pointOfTime, LocalTime.of(6, 30), LocalTime.of(6, 59)))
            return 13;

        // 07:00–07:59	SEK 18
        else if (within(pointOfTime, LocalTime.of(7, 0), LocalTime.of(7, 59)))
            return 18;

        // 08:00–08:29	SEK 13
        else if (within(pointOfTime, LocalTime.of(8, 0), LocalTime.of(8, 29)))
            return 13;

        // 08:30–14:59	SEK 8
        else if (within(pointOfTime, LocalTime.of(8, 30), LocalTime.of(14, 59)))
            return 8;

        // 15:00–15:29	SEK 13
        else if (within(pointOfTime, LocalTime.of(15, 0), LocalTime.of(15, 29)))
            return 13;

        // 15:30–16:59	SEK 18
        else if (within(pointOfTime, LocalTime.of(15, 30), LocalTime.of(16, 59)))
            return 18;

        // 17:00–17:59	SEK 13
        else if (within(pointOfTime, LocalTime.of(17, 0), LocalTime.of(17, 59)))
            return 13;

        // 18:00–18:29	SEK 8
        else if (within(pointOfTime, LocalTime.of(18, 0), LocalTime.of(18, 29)))
            return 8;

        // 18:30–05:59	SEK 0
        else return 0;
    }

    private static Boolean IsTollFreeDate(LocalDateTime date)
    {
        int year = date.getYear();
        int month = date.getMonth().getValue(); // TODO: check if this is correct as its not zerobased
        int day = date.getDayOfWeek().getValue(); // TODO: check if this is correct as its not zerobased
        int dayOfMonth = date.getDayOfMonth();

        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) return true;

        if (year == 2013)
        {
            return (month == 1 && dayOfMonth == 1) ||
                    (month == 3 && (dayOfMonth == 28 || dayOfMonth == 29)) ||
                    (month == 4 && (dayOfMonth == 1 || dayOfMonth == 30)) ||
                    (month == 5 && (dayOfMonth == 1 || dayOfMonth == 8 || dayOfMonth == 9)) ||
                    (month == 6 && (dayOfMonth == 5 || dayOfMonth == 6 || dayOfMonth == 21)) ||
                    (month == 7) ||
                    (month == 11 && dayOfMonth == 1) ||
                    (month == 12 && (dayOfMonth == 24 || dayOfMonth == 25 || dayOfMonth == 26 || dayOfMonth == 31));
        }
        return false;
    }

    public static boolean within(
            LocalTime time,
            LocalTime startInterval,
            LocalTime endInterval)
    {
        /*LocalDateTime start = LocalDateTime.from(startInterval);
        LocalDateTime end = LocalDateTime.from(endInterval);*/
        return !time.isBefore(startInterval) && !time.isAfter(endInterval);
    }
}
