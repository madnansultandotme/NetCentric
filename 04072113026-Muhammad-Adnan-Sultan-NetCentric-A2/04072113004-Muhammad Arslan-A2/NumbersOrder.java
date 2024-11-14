import java.util.Arrays;

public class NumbersOrder {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2, 7, 4, 6};

        // Find the largest and smallest number
        int largest = numbers[0];
        int smallest = numbers[0];
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
            if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);

        // Sort the array in ascending order
        Arrays.sort(numbers);
        System.out.println("Array in ascending order: " + Arrays.toString(numbers));

        // Sort the array in descending order
        int[] descendingNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            descendingNumbers[i] = numbers[numbers.length - 1 - i];
        }
        System.out.println("Array in descending order: " + Arrays.toString(descendingNumbers));
    }
}