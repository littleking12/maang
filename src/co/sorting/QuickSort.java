package co.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = { 7, 2, 8, 3, 9, 1, 0, 4, 6, 3, 8, 5 };
        quickSortAlgo(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "->");
        }
        System.out.println("");
    }

    public static void quickSortAlgo(int[] a, int start, int end) {
        if (start < end) {
            int pivot = getPartition(a, start, end);
            quickSortAlgo(a, start, pivot - 1);
            quickSortAlgo(a, pivot + 1, end);
        }
    }

    private static int getPartition(int[] a, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + "-");
        }
        System.out.println("");

        int pivot = a[end];
        int i = start;
        for (int j = start; j < end - 1; j++) {
            if (a[j] < pivot) {
                swapData(a, i, j);
                i++;
            }
        }
        if (a[i] > a[end]) {
            swapData(a, i, end);
        }
        return i;
    }

    private static void swapData(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}