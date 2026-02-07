import java.util.Random;

public class Tester {

    private SortingAlgorithm sort;

    public Tester(SortingAlgorithm sa) {
        this.sort = sa;
    }

    // generate random array
    private int[] makeRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }

        return arr;
    }

    // Runs one timed test
    public double singleTest(int size) {
        int[] arr = makeRandomArray(size);

        long start = System.currentTimeMillis();
        arr = sort.sorty(arr);
        long end = System.currentTimeMillis();

        return (end - start);
    }

    // Runs multiple tests and return average
    public double test(int iterations, int size) {
        double total = 0;

        for (int i = 0; i < iterations; i++) {
            total += singleTest(size);
        }

        return total / iterations;
    }
}


