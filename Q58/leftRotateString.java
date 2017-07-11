/*
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */

public class Solution {
    public void Reverse(char[] chars, int start, int end){
        for(int i = start; i <= (start + end) / 2; i++){
            char tmp = chars[i];
            chars[i] = chars[start + end - i];
            chars[start + end - i] = tmp;
        }
    }
    public String LeftRotateString(String str,int n) {
        if(n == 0 || str == null) return str;
        char[] chars = str.toCharArray();
        if(n < str.length() && n > 0){
            Reverse(chars, 0, n-1);
            Reverse(chars, n, str.length() - 1);
            Reverse(chars, 0, str.length() - 1);
        }
        return String.valueOf(chars);
    }
}
