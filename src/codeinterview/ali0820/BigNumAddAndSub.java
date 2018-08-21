package codeinterview.ali0820;

import java.util.regex.Pattern;

public class BigNumAddAndSub {

    public static boolean isNum(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static String bigNumAdd(String str1, String str2) {
        int lenA = str1.length();
        int lenB = str2.length();
        //如果字符串包含非数字字符 直接返回
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty() || !isNum(str1) || !isNum(str2))
            return null;
        if (lenA <= 0) {
            return str2;
        }
        if (lenB <= 0) {
            return str1;
        }
        String result = "";
        int i = lenA - 1, j = lenB - 1;
        int a, b, curSum, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {// 从末位开始相加
            a = i >= 0 ? str1.charAt(i) - '0' : 0;
            b = j >= 0 ? str2.charAt(j) - '0' : 0;
            curSum = a + b + carry; // 相加并加上进位
            carry = curSum / 10;// 进位
            result = (curSum % 10) + result;
            --i;
            --j;
        }
        return result;
    }

    //str1-str2
    public static String bigNumSub(String str1, String str2) {
        int lenA = str1.length();
        int lenB = str2.length();
        //如果字符串包含非数字字符 直接返回
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty() || !isNum(str1) || !isNum(str2))
            return null;
        if (lenA <= 0) {
            return str2;
        }
        if (lenB <= 0) {
            return str1;
        }
        boolean flag = true;
        if (lenA < lenB || (lenA == lenB && str1.compareTo(str2) < 0)) {
            //交换str
            String tmpStr = str1;
            str1 = str2;
            str2 = tmpStr;
            //交换长度
            int tmpInt = lenA;
            lenA = lenB;
            lenB = tmpInt;
            flag = false;
        }
        String result = "";
        int i = lenA - 1, j = lenB - 1;
        int a, b, curSum, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {// 从末位开始相减
            a = i >= 0 ? str1.charAt(i) - '0' : 0;
            b = j >= 0 ? str2.charAt(j) - '0' : 0;
            curSum = a - b + carry; // 相加并加上进位
            if (curSum < 0) {
                carry = -1;
                curSum += 10;
            }
            carry = curSum / 10;// 进位
            result = (curSum % 10) + result;
            --i;
            --j;
        }
        result = result.replaceAll("^[0]+", "");// 删除前导0
        return flag ? result : "-" + result;
    }

    public static void main(String[] args) {
        String str1 = "672";
        String str2 = "348";
        System.out.println(bigNumSub(str1, str2));
    }
}
