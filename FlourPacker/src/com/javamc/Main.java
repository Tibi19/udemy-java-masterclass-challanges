package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 4, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));
        System.out.println();
        System.out.println(canPack(2, 1, 12));
    }

    public static boolean canPack (int bigCount, int smallCount, int goal) {

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        final int BIG_BAG_KG = 5;
        final int SMALL_BAG_KG = 1;
        final int MAX_BIG_BAGS = goal / BIG_BAG_KG; // How many big bags can fit inside the goal.
        final int MAX_SMALL_BAGS = goal; // How many small bags can fit inside the goal.

        // Start of the for loop that counts each kind of bags
        // Can't be bigger than the number of available bags,
        // Or bigger than the number of possible bags.
        // Therefore, select the smaller between the two to satisfy both conditions.
        final int BIG_BAG_COUNT_START = Math.min(bigCount, MAX_BIG_BAGS);
        final int SMALL_BAG_COUNT_START = Math.min(smallCount, MAX_SMALL_BAGS);

        // Check for each combination of bags if they fit inside the goal.
        // Except for the situation in which we would use 0 big bags.
        for (int i = BIG_BAG_COUNT_START; i > 0; i--) {

            // How much of the goal should still be filled if @i bags are used.
            int remainingGoal = goal - (i * BIG_BAG_KG);

            // If @remainingGoal is 0, the goal has been reached.
            if (remainingGoal == 0) {
                return true;
            }

            // If @j bags fit inside the remaining goal perfectly, the goal is reached and we can return true.
            for (int j = SMALL_BAG_COUNT_START; j > 0; j--) {
                if (remainingGoal - (j * SMALL_BAG_KG) == 0) {
                    return true;
                }
            }
        }

        // Check if we can reach the goal when using 0 big bags
        // One small bag is 1 kg, therefore we just need to have at least the same amount of small bags as the maximum needed.
        if (smallCount >= MAX_SMALL_BAGS) {
            return true;
        }

        // The goal can't be reached, return false.
        return false;
    }

}
