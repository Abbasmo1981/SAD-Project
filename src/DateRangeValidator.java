package com.stockapp.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateRangeValidator implements IDateRangeValidator {

    @Override
    public boolean isValidRange(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long years = ChronoUnit.YEARS.between(startDate, endDate);
        return years <= 2;
    }
}
