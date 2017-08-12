/*
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */

//主要考虑一下几种情况
//1，输入为空
//2，输入只包含一个“+”或一个“-”
//3，输入中包含非数字字符
//4，溢出


public class Solution {
    public int StrToInt(String str) {
        if(str.length() == 0 || str == null) return 0;
        int symbol = 1;
        boolean isValid = true;
        char[] nums = str.toCharArray();
        int startIndex = 0;
        if(nums[0] == '+' || nums[0] == '-'){
            startIndex++;
            if(str.length() == 1){
                isValid = false;
                return 0;
            }
            if(nums[0] == '-')
                symbol = -1;
        }
        int rst = 0;
        for(int i = startIndex; i < str.length(); i++){
            if(nums[i] >= '0' && nums[i] <= '9'){
                rst = rst * 10 + (nums[i] - '0');
            }
            else{
                isValid = false;
                return 0;
            }
            if(rst > Integer.MAX_VALUE || rst < Integer.MIN_VALUE)
                return 0;
        }
        return symbol * rst;
    }
}
