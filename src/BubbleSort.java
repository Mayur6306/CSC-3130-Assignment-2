public class BubbleSort implements SortingAlgorithm {

    public int[] sorty(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Goes through list and swaps if out of order
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            // If no swaps happens, break
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}

