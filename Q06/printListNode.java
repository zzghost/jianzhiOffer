/*
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 */
import java.util.ArrayList;
public class printListNode {
    public class Solution {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        public void printNode(ListNode node){
            if(node == null)
                return ;
            else
                printNode(node.next);
            rst.add(node.val);
        }
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            printNode(listNode);
            return rst;
        }
    }
}
