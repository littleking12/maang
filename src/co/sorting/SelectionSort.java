package co.sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int a[] = { 1, 5, 2, 5, 7, 3, 9, 0 };
        outputArray(a);
        selectionSortAlgo(a);
        outputArray(a);

    }

    public static void selectionSortAlgo(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int minPosition = findMin(x, i);
            if (x[minPosition] < x[i]) {
                swapNumbers(x, i, minPosition);
            }
        }
    }

    private static void swapNumbers(int[] x, int i, int minPosition) {
        int temp =  x[i];
        x[i] = x[minPosition];
        x[minPosition] = temp;
    }

    private static int findMin(int[] x, int i) {
        int minPosition = i + 1;
        for (int j = i + 1; j < x.length; j++) {
            if (x[minPosition] > x[j]) {
                minPosition = j;
            }
        }
        return minPosition;
    }

    public static void outputArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if (i != x.length - 1)
                System.out.print("->");
            else
                System.out.println();
        }
    }
}
