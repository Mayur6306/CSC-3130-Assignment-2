import java.io.FileWriter;
import java.io.IOException;

public class Performance {

    public static void main(String[] args) throws IOException {

        // Declares algos
        SortingAlgorithm[] algos = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int iterations = 20;

        FileWriter fw = new FileWriter("report.txt");

        // Writes algos and runtime to file
        for (int a = 0; a < algos.length; a++) {
            SortingAlgorithm algo = algos[a];
            String name = algo.getClass().getSimpleName();

            // prints to console for easy viewing
            fw.write("Sorting algorithm – " + name + "\n");
            System.out.println("Sorting algorithm – " + name);

            Tester t = new Tester(algo);

            for (int s = 0; s < sizes.length; s++) {
                int n = sizes[s];

                double avg = t.test(iterations, n);

                // Flush allows writing while program and running
                fw.write("Sorted " + n + " elements in " + avg + " ms (avg)\n");
                fw.flush();
                System.out.println("Sorted " + n + " elements in " + avg + " ms (avg)");

            }

            fw.write("\n");
        }

        // Closes writer
        fw.close();
        System.out.println("Done");
    }
}

