/*
 *求数组中的逆序对数。（nums[i] > nums[j] && i < j)
 *要求结果如果大于1000000007，就取模。
 */

//解法：归并排序

public class Solution {
    int cnt = 0;
    public void merge(int[] array, int begin, int end, int mid){
        int[] temp = new int[end - begin + 1];
        int i, j, p;
        for(i = begin ,j = mid + 1, p = 0; i <= mid && j <= end; p++){
            if(array[i] <= array[j])
                temp[p] = array[i++];
            else{
                if(cnt >= 1000000007)
                    cnt %= 1000000007;
                cnt = cnt + (mid - i + 1);
                temp[p] = array[j++];
            }
        }
        while(i <= mid) temp[p++] = array[i++];
        while(j <= end) temp[p++] = array[j++];
        i = begin;p=0;
        while(i <= end)
            array[i++] = temp[p++];
    }
    public void mergesort(int[] array, int begin, int end){
        if(begin == end)
            array[begin] = array[end];
        else{
            int mid = (begin + end) / 2;
            mergesort(array, begin, mid);
            mergesort(array, mid+1, end);
            merge(array, begin, end, mid);
        }
    }
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int begin = 0, end = array.length - 1;
        mergesort(array, begin, end);
        if(cnt >= 1000000007)
            cnt %= 1000000007;
        return cnt;
    }
}
