public class QuickSort {
    static public void sort(int[] arr, int low, int high){
        int pivot = arr[high];
        int j = low;

        if(low < high) {
            for (int i = low; i < high; i++) {
                if (arr[i] < pivot) {
                    int buf = arr[j];
                    arr[j] = arr[i];
                    arr[i] = buf;
                    j++;
                }
            }

            int buf = arr[j];
            arr[j] = pivot;
            arr[high] = buf;

            if(j < high) sort(arr, j+1, high);
            if(j > low) sort(arr, low, j-1);
        }
    }
}
