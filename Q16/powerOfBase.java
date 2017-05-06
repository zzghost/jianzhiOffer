/*
 *给定一个double类型的浮点数base和int类型的整数exponent。
 *求base的exponent次方。
 */
//java里边本身有pow函数可以调用。
//我的解法：普通解法，考虑清楚了：exponent=0或者等于负数的情况。o(n)
//最好的解法：使用了之前斐波那契数列里遇到的乘法的优化，而且考虑全面了所有情况。o(logn)
public class Solution1 {
    public double Power(double base, int exponent) {
    //exponent可以为0,或为负数
    if(exponent == 0) return 1;
    int exp = Math.abs(exponent);
    double rst = 1;
    for(int i = 0; i < exp; i++)
        rst *= base;
    if(exponent < 0)
        rst = 1 / rst;
    return rst;
    }
}

public class Solution2 {
    public double Power(double base, int exponent) {
        //exponent可以为0,或为负数
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        int exp = Math.abs(exponent);
        double rst = 1;
        for(int i = 0; i < (exp>>1); i++)
            rst *= base;
        rst = rst * rst;
        if((exp & 0x1) == 1)
            rst = rst * base;
        if(exponent < 0)
            rst = 1 / rst;
         return rst;
    }
}
