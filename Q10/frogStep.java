/*
 * 青蛙跳台阶问题。
 * 1，普通青蛙跳台阶问题：一只青蛙一次跳上1级，也可以跳上2级台阶。求跳上n级台阶共几种跳法。
 * 2，变态青蛙跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以是2级，3级...n级。求该青蛙跳上一个n级台阶共有几种跳法。
 *
 */
//问题1:普通的斐波那契数列问题
//问题2:用数学归纳法证明，是f(n)=2的n-1次方
public class Solution {
        public int JumpFloorII(int target) {
                    if(target == 0) return 0;
                            return (int)Math.pow(2, target-1);
                                }
}
