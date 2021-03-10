package com.javamc;

public class Main {

    public static void main(String[] args) {

        int daysInJanuary2020 = NumberOfDaysInMonth.getDaysInMonth(1, 2020);
        int daysInFebruary2020 = NumberOfDaysInMonth.getDaysInMonth(2, 2020);
        int daysInFebruary2018 = NumberOfDaysInMonth.getDaysInMonth(2, 2018);
        int daysInError2020 = NumberOfDaysInMonth.getDaysInMonth(-1, 2020);
        int daysInJanuaryError = NumberOfDaysInMonth.getDaysInMonth(1, -2020);
        int daysInDecember2004 = NumberOfDaysInMonth.getDaysInMonth(12, 2004);
        int daysInApril2036 = NumberOfDaysInMonth.getDaysInMonth(4, 2036);
        int daysInSeptember1999 = NumberOfDaysInMonth.getDaysInMonth(9, 1999);
        int daysInMay2001 = NumberOfDaysInMonth.getDaysInMonth(5, 2001);

        System.out.println(daysInJanuary2020);
        System.out.println(daysInFebruary2020);
        System.out.println(daysInFebruary2018);
        System.out.println(daysInError2020);
        System.out.println(daysInJanuaryError);
        System.out.println();
        System.out.println(daysInDecember2004);
        System.out.println(daysInApril2036);
        System.out.println(daysInSeptember1999);
        System.out.println(daysInMay2001);

    }
}

class NumberOfDaysInMonth {

    public static boolean isLeapYear (int year) {

        if (year < 1 || year > 9999) {
            return false;
        }

        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }

    }

    public static int getDaysInMonth (int month, int year) {

        final int ERROR_INDICATOR_VALUE = -1;

        if (month < 1 || month > 12) {
            return ERROR_INDICATOR_VALUE;
        }

        if (year < 1 || year > 9999) {
            return ERROR_INDICATOR_VALUE;
        }

        final int MONTH_DAYS_LONG = 31;
        final int MONTH_DAYS_SHORT = 30;
        final int FEB_DAYS_DEFAULT = 28;
        final int FEB_DAYS_LEAP = 29;

        // If month is February, return appropriate days if it is a leap year or not.
        if (month == 2) {
            return isLeapYear(year) ? FEB_DAYS_LEAP : FEB_DAYS_DEFAULT;
        }

        // If month is before August (8th month) then:
        // Even months will have 30 days and odd months will have 31 days.
        // Otherwise, Even months will have 31 days and odd ones 30 days.
        if (month < 8) {
            return month % 2 == 0 ? MONTH_DAYS_SHORT : MONTH_DAYS_LONG;
        } else {
            return month % 2 == 0 ? MONTH_DAYS_LONG : MONTH_DAYS_SHORT;
        }

    }
}
