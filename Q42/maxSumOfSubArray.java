/*
 *数组里边包含负数
 *求连续子数组的最大和
 */

//比较简单的动态规划题

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] F = new int[array.length];
        F[0] = array[0];
        int max = Math.max(Integer.MIN_VALUE, F[0]);
        for(int i = 1; i < array.length; i++){
            F[i] = Math.max(F[i-1] + array[i], array[i]);
            max = Math.max(max, F[i]);
        }
        return max;
    }
}
