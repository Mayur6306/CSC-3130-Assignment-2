public class MergeSort implements SortingAlgorithm {

    public int[] sorty(int[] input) {
        int n = input.length;

        // base case
        if (n <= 1) {
            return input;
        }

        // split array
        int mid = n / 2;

        int[] l1 = new int[mid];
        int[] l2 = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l1[i] = input[i];
        }

        for (int i = mid; i < n; i++) {
            l2[i - mid] = input[i];
        }

        // recursive call
        l1 = sorty(l1);
        l2 = sorty(l2);

        // merge and return
        return merge(l1, l2);
    }

    private int[] merge(int[] l1, int[] l2) {
        int[] l3 = new int[l1.length + l2.length];

        int i = 0; // index for l1
        int j = 0; // index for l2
        int k = 0; // index for l3

        // Merges both arrays in l3
        while (i < l1.length && j < l2.length) {
            if (l1[i] < l2[j]) {
                l3[k] = l1[i];
                i++;
            } else {
                l3[k] = l2[j];
                j++;
            }
            k++;
        }

        // Copies remaining items
        while (i < l1.length) {
            l3[k] = l1[i];
            i++;
            k++;
        }

        while (j < l2.length) {
            l3[k] = l2[j];
            j++;
            k++;
        }

        return l3;
    }
}


