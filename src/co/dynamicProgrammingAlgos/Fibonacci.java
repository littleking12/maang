package co.dynamicProgrammingAlgos;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fiboRec(8));
        System.out.print(fiboDynamicBottomUp(8));
    }

    static int fiboRec(int i) {
        if (i == 0)
            return 1;
        if (i == 1)
            return 1;
        return fiboRec(i - 1) + fiboRec(i - 2);
    }

    static int fiboRecCache(int i) {
        Map<Integer, Integer> cache = new HashMap<>();
        if (i == 0)
            return 1;
        if (i == 1)
            return 1;
        int a, b;

        if (cache.containsKey(i - 1))
            a = cache.get(i - 1);
        else
            a = fiboRec(i - 1);

        if (cache.containsKey(i - 2))
            b = cache.get(i - 2);
        else
            b = fiboRec(i - 2);
        return a + b;
    }

    static int fiboDynamicBottomUp(int i) {
        int a = 1;
        int b = 1;
        if (i == 1) {
            return 1;
        }

        int total = 0;
        for (int j = 2; j <= i; j++) {
            total = a + b;
            a = b;
            b = total;
        }
        return b;
    }
}
//1 1 2 3 5 8 13 21 34