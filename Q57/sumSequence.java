/*
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */


//解法：同之前的题一样，用两个指针，初值分别为1和2。
//若low到high区间的所有数相加为sum，则加入aList
//若low到high区间的所有数相加小于sum，则high下移；否则low一直下移，直到currSum <= sum为止。

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> fList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(sum == 0){
            aList.add(0);
            fList.add(aList);
            return fList;
        }
        int low = 1, high = 2;
        int currSum = low + high;
        while(low < (sum + 1) / 2){
            if(currSum == sum){
                for(int i = low; i <= high; i++)
                    aList.add(i);
                fList.add(aList);
                aList = new ArrayList<Integer>();
            }
            while(currSum > sum && low < (sum + 1) / 2){
                currSum -= low;
                low++;
                if(currSum == sum){
                    for(int i = low; i <= high; i++)
                        aList.add(i);
                    fList.add(aList);
                    aList = new ArrayList<Integer>();
                }
            }
            high++;
            currSum += high;
        }
        return fList;
    }
}
