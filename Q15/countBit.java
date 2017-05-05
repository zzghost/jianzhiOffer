/*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

//解法1：java里边Integer有函数bitCount()可以直接调用；
//解法2：如下。尽量不要用右移来判断，因为可能出现死循环。


public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while(n != 0){
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }
}
