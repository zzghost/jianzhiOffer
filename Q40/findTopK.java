/*
 *输入n个整数，找出其中最小的K个数。
 *例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。 
 */

//解法1：直接调用java的排序函数，取前k个o(nlogn)，时间37ms
//解法2：快速排序的分治思想。取得的k个数未必是排好序的。时间39ms
//解法3：使用java里的treeset，treeset底层是红黑树实现的。treeset保存最小的k个数。时间38ms
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        java.util.ArrayList<Integer> aList = new java.util.ArrayList<Integer>();
        if(k == 0 || input == null || input.length == 0 || input.length < k) return aList;
        java.util.Arrays.sort(input);
        for(int i = 0; i < k; i++)
            aList.add(input[i]);
        return aList;
    }
}

public class Solution {
    public int partition(int[] input, int start, int end){
        int first = input[start];
        while(start < end){
            while(input[end] > first && end > start) end--;
            if(end > start)
                input[start++] = input[end];
            while(input[start] < first && end > start) start++;
            if(end > start)
                input[end--] = input[start];
        }
        input[start] = first;
        return start;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(k == 0 || input == null || input.length == 0 || input.length < k) return aList;
        int start = 0, end = input.length - 1;
        int idx = partition(input, start, end);
        while(idx != k - 1){
            if(idx > k - 1){
                end = idx - 1;
                idx = partition(input, start, end);
            }
            else{
                start = idx + 1;
                idx = partition(input, start, end);
            }
        }
        for(int i = 0; i < k; i++)
            aList.add(input[i]);
        return aList;
    }
}
