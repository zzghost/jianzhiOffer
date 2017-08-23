/*
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 *
 */

//暴力解决：每次都遍历一遍滑动窗口里的数
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || num.length == 0)
            return null;
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(size == 0 || num.length < size)
            return aList;
        for(int i = 0; i <= num.length - size; i++){
            int max = num[i];
            for(int j = 1; j < size; j++){
                max = Math.max(max, num[i+j]);
            }
            aList.add(max);
        }

        return aList;
    }
}

//用一个双端队列保存有可能成为最大值的数组下标。
//出现在队头的是最大值，之后的数字都是最大值的候选值。
//以{2,3,4,2,6,2,5,1},n=3为例，
//队列初始为2
//3>2,因此2不可能成为最大值，从队尾移除2，存入3
//4>3,因此3不可能成为最大值，从队尾移除3，存入4
//此时滑动窗口已有3个值，aList.add(4)
//2<4,当4滑出窗口以后,2有可能成为最大值，从队尾存入2
//6>2,6>4，所以4和2都不可能成为最大值，从队尾移除2,4,存入6，此时6仍然位于队头
//6>2，2仍然有可能成为最大，从队尾存入2
//5>2，从队尾移除2，存入5
//1<5，1存入尾部；此时6不在滑动窗口当中，应当移除。


public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || num.length == 0)
            return null;
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(size == 0 || num.length < size)
            return aList;
        Deque<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < size; i++){
            while(!queue.isEmpty() && num[queue.getLast()] <= num[i])
                queue.removeLast();
            queue.addLast(i);
        }
        for(int i = size; i < num.length; i++){
            aList.add(num[queue.getFirst()]);
            while(!queue.isEmpty() && num[queue.getLast()] <= num[i])
                queue.removeLast();
            if(!queue.isEmpty() && queue.getFirst() <= (int)(i - size))
                queue.removeFirst();
            queue.addLast(i);
        }
        aList.add(num[queue.getFirst()]);
        return aList;
    }
}
