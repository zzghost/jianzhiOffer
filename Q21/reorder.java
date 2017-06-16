/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。 
 */

//解法1：首先想到的是类似冒泡排序，从左往右遍历，前偶后奇就交换位置。
//时间复杂度是O(n^2)
public class Solution {
    public void reOrderArray(int [] array) {
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] % 2 == 0 && array[j+1] % 2 != 0){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}
//解法2：利用插入排序的思想。
//i从左向右遍历，找到第一个偶数；
//j从i+1开始找，找到第一个奇数；
//将[i,...,j-1]个元素整体后移一位，最后将找到的奇数放在i的位子，然后i++
//终止条件：j向后遍历查找失败。
//时间复杂度也是o(n^2)
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)
            return ;
        int size = array.length;
        int j = 0;
        for(int i = 0; i < size; ){
            while(i < size && array[i] % 2 != 0)
                i++;
            j = i + 1;
            while(j < size && array[j] % 2 == 0)
                j++;
            if(j < size){
                int tmp = array[j];
                for(int j2 = j-1; j2 >=i; j2--)
                    array[j2+1] = array[j2];
                array[i++] = tmp;
            }
            else
                break;
        }
    }
}
//如果题目没要求要保证数之间的相对位置的话，可以用类似快排的思想，用两个指针，奇数和偶数交换位置。但本题不可行。
//
//解法3：以空间换时间。
//用一个数组保存遍历到的偶数。
public class Solution {
    public boolean isEven(int num){
        return (num % 2 == 0);
    }
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)  return ;
        int[] evenArr = new int[array.length];
        int j = 0, countOdd = 0;
        for(int i = 0; i < array.length;i++){
            if(isEven(array[i])){
                evenArr[j++] = array[i];
            }
            else{
                array[countOdd++] = array[i];
            }
        }
        for(int i = countOdd; i < array.length; i++){
            array[i] = evenArr[i-countOdd];
        }
    }
}


