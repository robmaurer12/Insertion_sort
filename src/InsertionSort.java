import java.util.Random;

public class InsertionSort {

    // Global counter to keep track of the number of key comparisons
    static int COMPCOUNT = 0;

    // Compares arr[i] and arr[j] and increments COMPCOUNT
    public static boolean SMALLER(int[] arr, int arr_i, int j) {
        COMPCOUNT++;
        return arr_i < arr[j];
    }

    // This is the Insertion Sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int arr_i = arr[i];
            int j = i - 1;
            while (j >= 0 && SMALLER(arr, arr_i, j)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = arr_i;
        }
    }

    // Print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Generates worst case input (reverse sorted)
    public static int[] generateWorstCase(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }
        return array;
    }

    // Generates best case input (sorted)
    public static int[] generateBestCase(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Generates random input
    public static int[] generateRandomCase(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }

    public static void main(String[] args) {
        // 1.) Small-Size Array, n = 32
        int n = 32;

        // Worst-Case: Reverse Sorted
        int[] worstCase = generateWorstCase(n);
        COMPCOUNT = 0;
        System.out.println("Worst-case (Reverse Sorted):");
        System.out.println("For n = " + n);
        System.out.println("Input Array:");
        printArray(worstCase);
        insertionSort(worstCase);
        System.out.println("Sorted Output Array:");
        printArray(worstCase);
        System.out.println("Key Comparisons: " + COMPCOUNT);

        // Best-Case: Already Sorted
        int[] bestCase = generateBestCase(n);
        COMPCOUNT = 0;
        System.out.println("\nBest-case (Already Sorted):");
        System.out.println("For n = " + n);
        System.out.println("Input Array:");
        printArray(bestCase);
        insertionSort(bestCase);
        System.out.println("Sorted Output Array:");
        printArray(bestCase);
        System.out.println("Key Comparisons: " + COMPCOUNT);

        // Average-Case: Random
        int[] randomCase = generateRandomCase(n);
        COMPCOUNT = 0;
        System.out.println("\nAverage-case (Random Data):");
        System.out.println("For n = " + n);
        System.out.println("Input Array:");
        printArray(randomCase);
        insertionSort(randomCase);
        System.out.println("Sorted Output Array:");
        printArray(randomCase);
        System.out.println("Key Comparisons: " + COMPCOUNT);

        // Case 2.) Increasing Array Sizes, n = 100, n = 1000, n = 10000
        int[] sizes = {100, 1000, 10000};
        for (int size : sizes) {
            int[] randomArray = generateRandomCase(size);
            COMPCOUNT = 0;
            insertionSort(randomArray);
            System.out.println("\nFor n = " + size + ":");
            System.out.println("Key Comparisons: " + COMPCOUNT);
        }
    }
}