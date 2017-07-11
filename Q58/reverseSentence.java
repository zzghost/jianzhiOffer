/*
 * 翻转单词顺序.
 *　“I am a student.”翻转成“student. a am I”
 */

//解法：整体先翻转，再每个单词翻转
//
public class Solution {
    public void Reverse(char[] chars, int start, int end){
        if(start >= end || end >= chars.length) return ;
        for(int i = start; i <= (end + start) / 2; i++){
            char tmp = chars[i];
            chars[i] = chars[end + start - i];
            chars[end + start - i] = tmp;
        }
    }
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        Reverse(chars, 0, str.length() - 1);
        int low = 0, high = low;
        while(high < str.length()){
            high = low;
            while(high < str.length() && chars[high] != ' ') high++;
            if(high < str.length()){
                Reverse(chars, low, high - 1);
                low = high + 1;
            }
        }
        Reverse(chars, low, high - 1);
        return String.valueOf(chars);
    }
}
