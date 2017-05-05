/*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

//解法1：java里边Integer有函数bitCount()可以直接调用；
//解法2：使用右移，结束条件为数字为0。这种方法比较容易想到，但是存在一个问题，就是如果是负数，一直右移变成了0xFFFFFFFF，最终陷入死循环。
//      破解办法：设立flag，让它左移，终止条件，flag==0
//解法3：把一个整数减去1，就是把最右边的一个1从1变成0，二进制数字中有几个1就进行几次这样的操作。

//解法2
public class Solution {
    public int NumberOf1(int n) {
        //无符号
        int flag = 1 & 0xFFFF;
        int cnt = 0;
        while(flag != 0){
            if((flag & n) != 0)
                cnt++;
            flag = flag << 1;
        }
        return cnt;
    }
}

//解法3
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
