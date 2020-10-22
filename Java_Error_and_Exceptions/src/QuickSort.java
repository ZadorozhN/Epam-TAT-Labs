import java.util.Comparator;

public class QuickSort {
    public static <T> void sort(T[] arr, int low, int high, Comparator<T> comparator){
        T pivot = arr[high];
        int j = low;

        for(int i = low; i < high; i++){
            if(comparator.compare(arr[i], pivot) == 1){
                T buf = arr[j];
                arr[j] = arr[i];
                arr[i] = buf;
                j++;
            }
        }

        if(j < high) sort(arr, j + 1, high, comparator);
        if(j > low) sort(arr, low, j - 1, comparator);
    }
}
