public class StringReverse {

    // Method to reverse a string using a loop
    public static String reverseWithLoop(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // Method to reverse a string using recursion
    public static String reverseWithRecursion(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseWithRecursion(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String originalString = "Hello, World!";
        
        String reversedWithLoop = reverseWithLoop(originalString);
        System.out.println("Reversed with loop: " + reversedWithLoop);
        
        String reversedWithRecursion = reverseWithRecursion(originalString);
        System.out.println("Reversed with recursion: " + reversedWithRecursion);
    }
}