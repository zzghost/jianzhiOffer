/*
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *如果不存在则输出0。
 */

//解法1：基于排序，中位数必然是要找的数。运行时间35ms
//解法2：在遍历数组的时候保存两个值，一个是数组中的数字，一个是次数。遍历到下一个数字的时候，如果是和之前保存的一样，次数+1，不同则-1；次数为0则更新数字与次数。运行时间28ms

public class Solution {
    public boolean checkIfHalf(int[] array, int middle){
        int count = 0;
        for(int x : array)
            if(x == middle)
                count++;
        return (count > array.length / 2);
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length ==0 || array == null) return 0;
        java.util.Arrays.sort(array);
        int middle = array[array.length / 2];
        if(checkIfHalf(array, middle))
            return middle;
        else
            return 0;
    }
}

public class Solution {
    public boolean checkIfHalf(int[] array, int rst){
        int count = 0;
        for(int x : array)
            if(x == rst)
                count++;
        return (count > array.length/2);
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length ==0 || array == null) return 0;
        int rst = array[0], count = 1;
        for(int i = 1; i < array.length; i++){
            if(count == 0){
                rst = array[i];
                count = 1;
            }
            else
                if(rst == array[i])
                    count++;
                else
                    count--;
        }

        if(checkIfHalf(array, rst))
            return rst;
        else
            return 0;
    }
}
