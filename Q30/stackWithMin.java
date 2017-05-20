/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 要求时间复杂度o(1)
 */
//解法：首先会想到，用一个min值来记录每次push进栈一个元素后，栈里边的最小元素。
//但是，这会引起我们思考：如果当前的最小值被弹出来了，那接下来的最小元素是多少？
//所以这种方法不可行。
//可以考虑：用一个辅助栈，记录原来栈对应位置处的最小值是多少。
import java.util.Stack;

public class Solution {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> minSt = new Stack<Integer>();
    int min;
    public void push(int node) {
        if(st.empty())
            min = node;
        st.push(node);
        if(min >= node){
            minSt.push(node);
            min = node;
        }
        else
            minSt.push(min());
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return minSt.peek();
    }
}
