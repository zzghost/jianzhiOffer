/*
 * 输入一个链表，反转链表.
 */

//解法1：递归
//非常巧妙。先到链表尾部，再进行反转，这过程中pReverse始终是原链表的尾部节点。

public class solution1{
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pReverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pReverse;
    }
}
//解法2：非递归
//头插法反转链表
public class solution2{
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head, p = head.next;
        head.next = null;
        while(p != null){
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }
}
