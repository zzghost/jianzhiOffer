/*
 *圆圈中最后一个数字
 */

//解法：用公式.考察发散思维能力


public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        int last = 0;
        for(int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }
}
