/*
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的
 * 所有字符串abc,acb,bac,bca,cab和cba。 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

//解法:全排列，递归

import java.util.ArrayList;
public class Solution {
    ArrayList<String> finalList = new ArrayList<String>();
    public void permutation(char[] str, int start){
        int len = String.valueOf(str).length();
        if(start == len - 1){
            String tmp = String.valueOf(str);
            if(!finalList.contains(tmp))
                finalList.add(tmp);
            return;
        }
        char firstChar = str[start];
        for(int i = start ; i < len; i++){
            char t = str[i];
            str[i] = firstChar;
            str[start] = t;
            permutation(str, start + 1);

            str[i] = t;
            str[start] = firstChar;
        }

    }
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.equals("")) return finalList;
        finalList.add(str);
        if(str.length() == 1)
            return finalList;
        char[] st = str.toCharArray();
        permutation(st, 0);
        java.util.Collections.sort(finalList);
        return finalList;
    }
}
