package com.javamc;

public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes (int kiloBytes) {

        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {

            int kbToMb = 1024;
            int megaBytes = kiloBytes / kbToMb;
            int remainderKb = kiloBytes % kbToMb;

            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainderKb + " KB");
        }
    }
}
