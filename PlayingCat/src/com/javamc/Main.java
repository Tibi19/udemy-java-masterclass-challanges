package com.javamc;

public class Main {

    public static void main(String[] args) {

        boolean bool1 = PlayingCat.isCatPlaying(true, 10);
        boolean bool2 = PlayingCat.isCatPlaying(false, 36);
        boolean bool3 = PlayingCat.isCatPlaying(false, 35);

        System.out.println(bool1);
        System.out.println(bool2);
        System.out.println(bool3);
    }
}
