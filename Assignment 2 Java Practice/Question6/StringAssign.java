import java.util.HashMap;
import java.util.Map;

public class StringAssign {
    public static void main(String[] args) {
        String text = "example text for counting letters";
        
        Map<Character, Integer> letterCount = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}