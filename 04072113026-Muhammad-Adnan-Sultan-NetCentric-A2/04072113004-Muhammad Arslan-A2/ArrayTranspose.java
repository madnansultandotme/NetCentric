public class ArrayTranspose {

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}
        };

        System.out.println("Original Array:");
        printArray(array);

        int[][] transposedArray = transpose(array);

        System.out.println("Transposed Array:");
        printArray(transposedArray);
    }

    // Method to transpose a 2D array
    public static int[][] transpose(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        int[][] transposed = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = array[i][j];
            }
        }

        return transposed;
    }

    // Method to print a 2D array
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
