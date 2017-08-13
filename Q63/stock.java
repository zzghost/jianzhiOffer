/*
 * 把股票的价格存在一维数组当中，请问买卖该股票可获得的最大利润是多少。
 */

//解法：最大利润是买卖股票的最大差值，也就是求数组中所有数对的最大差值。
//一道最简单的dp问题。时间效率o(n)

public class Solution {
    public static int MaxDiff(int[] array){
        if(array.length < 2 || array == null)
            return 0;
        int Min = array[0];
        int rst = array[1] - Min;
        for(int i = 2; i < array.length; i++){
            if(array[i] < Min)
                Min = array[i];
            int current = array[i] - Min;
            rst = Math.max(current, rst);
        }
        return rst;
    }
    public static void main(String[] args){
        int[] array = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(MaxDiff(array));
    }
}
