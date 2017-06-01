/*
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数.
 */

//解法：直接求解会超时。由于丑数都是由2,3,5组成的，只要用2,3,5去乘以当前丑数，然后每次取出最小的那个丑数即可。
//可以用最小堆保存乘出来的中间结果

import java.util.*;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        TreeSet<Integer> tSet = new TreeSet<Integer>();
        int[] rst = new int[index+1];
        if(index <= 0) return 0;
        rst[0] = 0;
        rst[1] = 1;
        int i = 1;
        int M = rst[1];
        while(i < index){
            tSet.add(M * 2);
            tSet.add(M * 3);
            tSet.add(M * 5);
            int tmp = tSet.pollFirst();
            while(tmp <= M)
                tmp = tSet.pollFirst();
            rst[++i] = tmp;
            M = rst[i];
        }
        return rst[index];
    }
}
