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
}
