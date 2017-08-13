/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */

//思路：利用字符串字典排序的方法
//由于s1与s2两个字符串拼接以后，无论是s1+s2还是s2+s1，总长度不变。
//因此两者拼接以后，可以直接比较判断拼接后数字大小。
//利用Arrays.sort()函数，将所有字符串排序。
//最后做总拼接即可


import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] st = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            st[i] = String.valueOf(numbers[i]);
        java.util.Arrays.sort(st, new java.util.Comparator<String>(){
            public int compare(String s1, String s2){
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str1.compareTo(str2);
            }
        });
        for(String s : st)
            sb.append(s);
        return sb.toString();
    }
}
