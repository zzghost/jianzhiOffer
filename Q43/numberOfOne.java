/*
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */

//普通解法：对于每个数字，每一位进行判断。时间复杂度o(n*logn)
public class Solution {
    public int numberOfOne(int num){
        int cnt = 0;
        while(num != 0){
            int t = num % 10;
            if(t == 1)
                cnt++;
            num = num / 10;
        }
        return cnt;
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0) return 0;
        int number = 0;
        for(int i = 0; i <= n; i++){
            number += numberOfOne(i);
        }
        return number;
    }
}

//时间效率高的解法：
//从低位开始逐个数出当前位上会出现数字X的次数。
//设当前位是第i位，如果在i位上出现，则说明它总共会出现pow(10, i-1)次
//例如，n = 2000时，X=5会在个位出现了1次；在十位出现了10次；在百位出现了100次；最高位情况另外讨论
//但实际数字n往往不会这些低位都是0，有可能比X大，也有可能比X小。
//以n=21345,X=1为例，
//X在个位出现的次数等于2134+1次。基础值2134的含义是1~21340当中，X在个位出现了2134次；附加值1代表，21341~21345中，X出现在个位1次。
//以此类推。

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0) return 0;
        int rst = 0, num = (int)Math.log10(n) + 1;
        //这里我先求出了n的位数，也可以不求，另high=n，while循环写high!=0即可~
        for(int i = 0; i < num; i++){
            int high = n / (int)Math.pow(10, i+1);
            int low = n % (int)Math.pow(10, i+1);
            int weight = (int)Math.pow(10, i);
            rst += high * weight;
            int highestNumInLow = low / weight;
            if(highestNumInLow == 1){
                rst += (low - weight * highestNumInLow + 1);
                continue;
            }
            if(highestNumInLow > 1){
                rst += weight;
            }
        }
        return rst;
    }
}
