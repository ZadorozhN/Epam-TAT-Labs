package org.example;

public class QuickSort{

    public static void quickSort(int[] arr, int low, int high, App.BoolComparator<Integer> comparer) {
        int mainNode = arr[high];
        int count = low;

        if (low < high) {
            for (int i = low; i < high; i++) {
                if (comparer.compare(mainNode,arr[i])) {
                    int buf = arr[i];
                    arr[i] = arr[count];
                    arr[count] = buf;
                    count++;
                }
            }

            int buf = arr[count];
            arr[count] = mainNode;
            arr[high] = buf;

            if (count < high) quickSort(arr, count + 1, high, comparer);
            if (count > low) quickSort(arr, low, count - 1, comparer);
        }
    }

    public static void quickSortColumn(int[][] arr, int column, int low, int high, App.BoolComparator<Integer> comparer) {
        int mainNode = arr[high][column];
        int count = low;

        if (low < high) {
            for (int i = low; i < high; i++) {
                if (comparer.compare(mainNode,arr[i][column])) {
                    int buf = arr[i][column];
                    arr[i][column] = arr[count][column];
                    arr[count][column] = buf;
                    count++;
                }
            }

            int buf = arr[count][column];
            arr[count][column] = mainNode;
            arr[high][column] = buf;

            if (count < high) quickSortColumn(arr, column, count + 1, high, comparer);
            if (count > low) quickSortColumn(arr, column, low, count - 1, comparer);
        }
    }

}
