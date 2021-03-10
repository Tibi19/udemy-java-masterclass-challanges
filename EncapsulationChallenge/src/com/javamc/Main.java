package com.javamc;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(100, true);
        Printer oldPrinter = new Printer(20, 198, false);

        printer.printPage(false);
        printer.printPage(true);
        printer.printPages(11, true);
        System.out.println(printer.getTonerLevel());
        System.out.println(printer.getPagesPrinted());

        System.out.println();

        oldPrinter.printPages(21, true);
        oldPrinter.fillToner(25);
        System.out.println(oldPrinter.getTonerLevel());
        oldPrinter.printPages(21, true);
        oldPrinter.printPages(21, false);
        System.out.println(oldPrinter.getTonerLevel());
    }
}
