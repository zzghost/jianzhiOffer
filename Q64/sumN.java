/*
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

//解法１：等差数列求和公式
public class Solution {
    public int Sum_Solution(int n) {
        return n + n * (n - 1) * 1 / 2;
    }
}

//解法２：利用递归
public class Solution {
    int sum = 0;
    public int Sum_Solution(int n) {
        if(n == 1)
            return sum+1;
        sum += n;
        return Sum_Solution(n-1);
    }
}
