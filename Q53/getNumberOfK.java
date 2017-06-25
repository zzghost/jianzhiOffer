//统计一个数字在排序数组中出现的次数。
//
//
//解法１：顺序遍历数组。统计。时间复杂度O(n)
//解法２：考虑用二分查找。共用两次，一次找到数组中第一次出现的位置，第二次找到数字最后一次出现的位置。

public class Solution {
    public int getFirstK(int[] array, int k, int low, int high){
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        int midNum = array[mid];
        if(midNum == k){
            if(mid > 0 && array[mid-1] != k || mid == 0)
                return mid;
            else
                high = mid -1;
        }
        else if(midNum > k)
            high = mid - 1;
        else
            low = mid + 1;
        return getFirstK(array, k, low, high);
    }
    public int getLastK(int[] array, int k, int low, int high){
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        int midNum = array[mid];
        if(midNum == k){
            if(mid < high && array[mid+1] != k || mid == high)
                return mid;
            else
                low = mid + 1;
        }
        else if(midNum > k)
            high = mid - 1;
        else
            low = mid + 1;
        return getLastK(array, k, low, high);
    }
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if(array != null && array.length > 0){
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);

            if(first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;

    }
}
