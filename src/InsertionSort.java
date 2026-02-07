public class InsertionSort implements SortingAlgorithm {

    public int[] sorty(int[] arr) {

        // Go through array for each element and inserts at the right index
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }

        return arr;
    }
}

