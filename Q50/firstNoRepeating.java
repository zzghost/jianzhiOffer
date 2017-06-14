/*
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置 
 */

//解法：利用hashmap不能存在重复key的原理。遍历计算每个字母出现的次数
//再遍历一遍数组找到第一个出现一次的字符。

import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        java.util.Map<Character, Integer> aMap = new java.util.HashMap<Character, Integer>();
        char[] strArray = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(aMap.containsKey(strArray[i])){
                int sum = aMap.get(strArray[i]);
                sum++;
                aMap.put(strArray[i], sum);
            }
            else{
                aMap.put(strArray[i], 1);
            }
        }
        for(int i = 0; i < str.length(); i++){
            char curr = strArray[i];
            if(aMap.get(curr) == 1)
                return i;
        }
        return -1;
    }
}
