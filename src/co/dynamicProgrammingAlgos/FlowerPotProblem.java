package co.dynamicProgrammingAlgos;

import java.util.Stack;

public class FlowerPotProblem {
    public static void main(String[] args) {
        System.out.println(" ." + getMaxFlowers(new int[] { 9, 10, 9, 10, 9, 10, 9, 9 }));
        System.out.println(" ." + getMaxFlowers(new int[] { 9, 19, 9, 10, 30 }));
        System.out.println(" ." + getMaxFlowers(new int[] { 20, 9, 17, 9 }));
    }

    private static int getMaxFlowers(int[] ground) {

        int a = ground[0];
        int b = ground[1];
        int max = 0;
        for (int i = 2; i < ground.length; i++) {
            if (a + ground[i] < b) {
                max = b;
            } else {
                max = a + ground[i];
            }
            a = b;
            b = max;
        }
        return max;
    }

}
