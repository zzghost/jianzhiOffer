/*
 * 找到链表的倒数第k个节点
 */

//思路很简单：两个指针，一个先走k-1步，然后再一起走。
//重点是潜在的一些风险：1）如果给的节点为null，return null
//2)如果给的k为0，return null
//3)链表长度不足k，return null
//
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) return null;
        ListNode first = head, last = head;
        int cnt = 0;
        while(cnt < k && first != null){
            first = first.next;
            cnt++;
        }
        if(cnt < k)
            return null;
        else{
            while(first != null){
                first = first.next;
                last = last.next;
            }
            return last;
        }
    }
}
