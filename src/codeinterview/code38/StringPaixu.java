package codeinterview.code38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/16
 * Time: 20:14
 */
public class StringPaixu {
    HashSet<String> tmpSet = new HashSet<>();

    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null) return null;
        if (str.length() == 0) return result;
        Permutation(str.toCharArray(), str.toCharArray(), 0);
        tmpSet.forEach(p -> result.add(p));
        Collections.sort(result);
        return result;
    }

    private void Permutation(char[] str, char[] begin, int startIndex) {
        if (startIndex == str.length) {
            tmpSet.add(new String(begin));
        } else {
            for (int i = startIndex; i < str.length; i++) {
                char temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;

                Permutation(str, begin, startIndex + 1);

                temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        ArrayList<String> tmp = new StringPaixu().Permutation(str);
        tmp.forEach(p -> System.out.println(p));
    }
}
