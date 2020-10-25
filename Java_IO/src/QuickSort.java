public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        if(arr.length < 2) return;
        int pivot = arr[high];
        int j = low;

        if (low < high) {
            for (int i = low; i < high; i++) {
                if (arr[i] < pivot) {
                    int buf = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buf;
                    j++;
                }
            }

            int buf = arr[j];
            arr[j] = pivot;
            arr[high] = buf;

            if (j > low) sort(arr, low, j - 1);
            if (j < high) sort(arr, j  + 1, high);
        }
    }

    public static void sort2(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int middle = (i + j)/2;

        if(i <= j){
            while(arr[i] < arr[middle]){
                i++;
            }

            while(arr[j] > arr[middle]){
                j--;
            }
            if(i <= j){
                int buf = arr[i];
                arr[i] = arr[j];
                arr[j] = buf;
                i++;
                j--;
            }

            if(i < high) sort2(arr, i, high);
            if(j > low) sort2(arr, low, j);

        }

    }
}
