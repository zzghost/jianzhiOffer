/*
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
//解法：自然想到位运算。
//分成三步：
//1）异或运算，相当于每位相加，但不考虑进位。
//2）与运算、右移，相当于考虑进位。
//3）重复1与2，直到不产生进位为止。
public class Solution {
    public int Add(int num1,int num2) {
        if(num1 == 0) return num2;
        if(num2 == 0) return num1;
        while(num2 != 0){
            int carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }
        return num1;
    }
}
