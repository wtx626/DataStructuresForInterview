package codeinterview.code50;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (counts.containsKey(str.charAt(i))) {
                int update = counts.get(str.charAt(i)) + 1;
                counts.put(str.charAt(i), update);
            } else {
                counts.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("aaabbb"));
    }
}
