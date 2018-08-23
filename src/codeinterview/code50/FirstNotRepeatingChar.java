package codeinterview.code50;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
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
