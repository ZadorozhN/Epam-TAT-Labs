public class BinarySearch {
    public static Student search(Student[] arr,int low, int high, int value){
        if(low <= high) {
            int middle = (low + high) / 2;
            if(value == arr[middle].getId())
                return arr[middle];
            if(value < arr[middle].getId())
                return search(arr, low,middle - 1, value);
            if(value > arr[middle].getId())
                return search(arr, middle + 1, high, value);
        }
        return null;
    }
}
