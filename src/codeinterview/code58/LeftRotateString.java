package codeinterview.code58;

public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (n < 0 || n > str.length()) return str;
        StringBuffer result = new StringBuffer();
        for (int i = n; i < str.length(); i++)
            result.append(str.charAt(i));
        for (int i = 0; i < n; i++)
            result.append(str.charAt(i));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().LeftRotateString("abcdefg", 2));
    }
}
