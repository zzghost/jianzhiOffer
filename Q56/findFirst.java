/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 *
 */

//考虑：数组中只存在一个数字出现了一次，别的数字都出现了两次。
//这时，我们会用异或来做。
//因为一个数异或它本身，结果为０
//
//这道题也可以用异或来解。
//先用一遍异或，得到一个非0数，这个数是由这两个数字异或得到的。由于非0，则至少某一位为1。
//找到这个1所在的位置，把原数组分成两组，一组在这个位置上为1，另一组在这个位置上为0。
//这样就区别开了两个数字。
//分别用一次异或，则得到两个数字。


//num1[0]和num2[0]用来区分结果
public class Solution {
    public int findFirstBit(int rst){
        int idx = 0;
        int tmp = rst & 1;
        while( tmp == 0 && (idx < 32)){
            rst = rst >> 1;
            tmp = rst & 1;
            ++idx;
        }
        return idx;
    }
    public boolean isBit(int num, int idx){
        num = num >> idx;
        num = num & 1;
        return (num == 1);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
            return ;
        int rstEOR = 0;
        for(int x : array)
            rstEOR ^= x;
        int idx = findFirstBit(rstEOR);

        num1[0] = 0;
        num2[0] = 0;
        for(int j = 0; j < array.length; j++)
            if(isBit(array[j], idx))
                num1[0] ^= array[j];
            else
                num2[0] ^= array[j];
    }
}
