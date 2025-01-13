import java.io.*;
import java.util.*;

public class RandomNumberProcessing {

   
    private static final int MIN = 1;
    private static final int MAX = 10000;
    private static final int NUM_COUNT = 1000;
    private static final String FILE_NAME = "random_numbers.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        
        generateRandomNumbersToFile();

       
        int[] numbers = readNumbersFromFile();

        long startTimeThreads = System.nanoTime();
        int minWithThreads = findMinimumWithThreads(numbers);
        long endTimeThreads = System.nanoTime();

        long startTimeMain = System.nanoTime();
        int minWithoutThreads = findMinimumWithoutThreads(numbers);
        long endTimeMain = System.nanoTime();

        System.out.println("Minimum value using threads: " + minWithThreads);
        System.out.println("Minimum value without threads: " + minWithoutThreads);

        System.out.println("Time taken with threads: " + (endTimeThreads - startTimeThreads) + " ns");
        System.out.println("Time taken without threads: " + (endTimeMain - startTimeMain) + " ns");
    }

    
    private static void generateRandomNumbersToFile() throws IOException {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Random random = new Random();
            for (int i = 0; i < NUM_COUNT; i++) {
                int randomNum = MIN + random.nextInt(MAX - MIN + 1);
                writer.write(randomNum + "\n");
            }
        }
    }


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


    private static int findMinimumWithoutThreads(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            min = Math.min(min, num);
        }
        return min;
    }

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