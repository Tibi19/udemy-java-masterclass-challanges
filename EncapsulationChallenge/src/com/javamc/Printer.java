package com.javamc;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplexPrinter;

    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplexPrinter) {

        if (tonerLevel > 0 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        } else {
            tonerLevel = 0;
        }

        this.tonerLevel = tonerLevel;
        this.pagesPrinted = pagesPrinted;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public Printer(int tonerLevel, boolean isDuplexPrinter) {
        this(tonerLevel, 0, isDuplexPrinter);
    }

    public void fillToner(int fillAmount) {
        if (tonerLevel + fillAmount >= 100) {
            tonerLevel = 100;
            System.out.println("Toner level at maxixmum, can't fill anymore");
        } else {
            tonerLevel += fillAmount;
            System.out.println("Toner Level is now at " + tonerLevel + " %");
        }
    }

    public void printPage(boolean onBothSides) {
        if (tonerLevel > 0) {
            if (onBothSides && isDuplexPrinter) {
                System.out.println("Printing pages on both sides...");
                pagesPrinted += 2;
                tonerLevel -= 2;
            } else if (onBothSides) {
                System.out.println("Not a duplex printer, can't print on both sides");
            } else {
                System.out.println("Printing page...");
                pagesPrinted++;
                tonerLevel--;
            }
        } else {
            System.out.println("Toner level is 0");
        }
    }

    public void printPages(int numberOfPages, boolean printOnBothSides) {
        if (numberOfPages > tonerLevel) {
            System.out.println("Not enough toner, can print a maximum of " + tonerLevel + " pages.");
        } else if (printOnBothSides && isDuplexPrinter) {
            printPagesOnBothSides(numberOfPages);
        } else if (printOnBothSides) {
            System.out.println("Can't print " + numberOfPages + " pages on both sides, " +
                    "printer is not a duplex.");
        } else {
            printPagesOnOneSide(numberOfPages);
        }
    }

    private void printPagesOnOneSide(int numberOfPages) {
        int pagesPrinted;
        for (pagesPrinted = 0; pagesPrinted < numberOfPages; pagesPrinted++) {
            printPage(false);
        }
        System.out.println("Printed " + pagesPrinted + " pages");
    }

    private void printPagesOnBothSides(int numberOfPages) {
        int pagesPrinted;

        for (pagesPrinted = 0; pagesPrinted < numberOfPages - 1; pagesPrinted += 2) {
            printPage(true);
        }

        if (numberOfPages - pagesPrinted == 1) {
            printPage(false);
            pagesPrinted++;
        }

        System.out.println("Printed " + pagesPrinted + " pages");
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }
}
