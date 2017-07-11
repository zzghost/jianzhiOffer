/*
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

//解法：o(n^2)的思路是顺序查找下去。这个很容易想到。
//更好的解法就是用两个指针，指向首尾。若等于sum，则找到；小于sum，则小的后移；大于sum，则大的前移。
//时间复杂度o(n)

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(array.length == 0) return aList;
        int low = 0, high = array.length - 1;
        while(low < high){
            if(array[low] + array[high] == sum){
                aList.add(array[low]);
                aList.add(array[high]);
                return aList;
            }
            if(array[low] + array[high] < sum){
                low++;
            }
            else
                high--;
        }
        return aList;
    }
}
