package codeinterview.code05;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 10:39
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");
            } else newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        StringBuffer str=new StringBuffer("We Are Happy");
        System.out.println(new ReplaceSpace().replaceSpace(str));
    }
}
