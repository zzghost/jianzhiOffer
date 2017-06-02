/*
 *
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 */

//解法：用一个最大堆，一个最小堆。保证最小堆的size比最小堆大1或相等。

import java.util.*;

public class Solution {
    TreeSet<Integer> left = new TreeSet<Integer>();
    TreeSet<Integer> right = new TreeSet<Integer>();
    public double Median = 0;

    public void Insert(Integer num) {
        if(left.size() == 0 && right.size() == 0){
            left.add(num);
            Median = num;
            return ;
        }
        if(num > Median){
            right.add(num);
        }
        else{
            left.add(num);
        }
        if(left.size () - right.size() >= 2)
            right.add(left.pollLast());
        if(right.size() - left.size() >= 1)
            left.add(right.pollFirst());
        if(left.size() == right.size())
            Median = (double)(left.last() + right.first())/ 2;
        else
            Median = left.last();
    }

    public Double GetMedian() {
        return (double)Median;
    }
}
