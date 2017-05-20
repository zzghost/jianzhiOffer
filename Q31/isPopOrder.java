/*
 *
 *输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的)
 */

//解法：使用一个辅助栈模拟入与出栈
//要注意的是边界检查：栈空；序列长度为0

mport java.util.ArrayList;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len1 = pushA.length;
        if(len1 == 0)
            return true;
        java.util.Stack<Integer> st = new java.util.Stack<Integer>();
        st.push(pushA[0]);
        int i = 0, j = 1;
        boolean rst = true;
        while(!st.empty() || j < len1){
            while(!st.empty() && st.peek() == popA[i]){
                st.pop();
                i++;
            }
            if(j != len1){
                st.push(pushA[j]);
                j++;
            }
            else{
                if(i != len1 && st.peek() != popA[i]){
                    rst = false;
                    break;
                }
                else{
                    if(st.empty())
                        break;
                    else{
                        st.pop();i++;}
                }
            }
        }
        return rst;
    }
}
