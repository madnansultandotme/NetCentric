import java.io.*;
import java.util.*;

public class RandomNumberProcessing {

    // Constants for random number generation
    private static final int MIN = 1;
    private static final int MAX = 10000;
    private static final int NUM_COUNT = 1000;
    private static final String FILE_NAME = "random_numbers.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Step a: Generate random numbers and store in a file
        generateRandomNumbersToFile();

        // Step b: Read numbers from file and store them in an array
        int[] numbers = readNumbersFromFile();

        // Step c: Find minimum using multithreading
        long startTimeThreads = System.nanoTime();
        int minWithThreads = findMinimumWithThreads(numbers);
        long endTimeThreads = System.nanoTime();

        // Step d: Find minimum using main thread
        long startTimeMain = System.nanoTime();
        int minWithoutThreads = findMinimumWithoutThreads(numbers);
        long endTimeMain = System.nanoTime();

        // Output results
        System.out.println("Minimum value using threads: " + minWithThreads);
        System.out.println("Minimum value without threads: " + minWithoutThreads);

        System.out.println("Time taken with threads: " + (endTimeThreads - startTimeThreads) + " ns");
        System.out.println("Time taken without threads: " + (endTimeMain - startTimeMain) + " ns");
    }

    // Method to generate random numbers and store them in a file
    private static void generateRandomNumbersToFile() throws IOException {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Random random = new Random();
            for (int i = 0; i < NUM_COUNT; i++) {
                int randomNum = MIN + random.nextInt(MAX - MIN + 1);
                writer.write(randomNum + "\n");
            }
        }
    }

    // Method to read numbers from file into an array
    private static int[] readNumbersFromFile() throws IOException {
        int[] numbers = new int[NUM_COUNT];
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                numbers[index++] = Integer.parseInt(line);
            }
        }
        return numbers;
    }

    // Method to find the minimum using multithreading
    private static int findMinimumWithThreads(int[] numbers) throws InterruptedException {
        int threadCount = 5;
        int chunkSize = numbers.length / threadCount;
        MinFinderThread[] threads = new MinFinderThread[threadCount];
        
        for (int i = 0; i < threadCount; i++) {
            int start = i * chunkSize;
            int end = (i == threadCount - 1) ? numbers.length : start + chunkSize;
            threads[i] = new MinFinderThread(numbers, start, end);
            threads[i].start();
        }

        int globalMin = Integer.MAX_VALUE;
        for (MinFinderThread thread : threads) {
            thread.join();
            globalMin = Math.min(globalMin, thread.getMin());
        }
        return globalMin;
    }

    // Method to find the minimum without multithreading
    private static int findMinimumWithoutThreads(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            min = Math.min(min, num);
        }
        return min;
    }

    // Thread class for finding minimum in a chunk of the array
    private static class MinFinderThread extends Thread {
        private final int[] numbers;
        private final int start;
        private final int end;
        private int min = Integer.MAX_VALUE;

        public MinFinderThread(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                min = Math.min(min, numbers[i]);
            }
        }

        public int getMin() {
            return min;
        }
    }
}