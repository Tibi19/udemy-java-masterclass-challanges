package com.javamc;

public class Main {

    public static void main(String[] args) {
	    int day = 7;
	    printDayOfTheWeek(day);
	    printDayOfTheWeekEasier(day);
    }

    private static void printDayOfTheWeek (int day) {
        switch (day) {
            case 0:
                System.out.println("Monday");
                break;
            case 1:
                System.out.println("Tuesday");
                break;
            case 2:
                System.out.println("Wednesday");
                break;
            case 3:
                System.out.println("Thursday");
                break;
            case 4:
                System.out.println("Friday");
                break;
            case 5:
                System.out.println("Saturday");
                break;
            case 6:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Only 7 days, my dude, from 0 to 6");
                break;
        }
    }

    private static void printDayOfTheWeekEasier (int day) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"};

        if (day < 0 || day > 6) {
            System.out.println("Easier method would Like you to stay between the lines, like in kindergarten");
        } else {
            System.out.println("Easier method says it's " + days[day]);
        }

    }
}
