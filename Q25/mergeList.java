/*
 *输入两个单调递增的链表，输出两个链表合成后的链表，
 *当然我们需要合成后的链表满足单调不减规则。
 */

//解法1：非递归版本
//批量插入到list1中。每个链表要有2个指针，list2是插入头与插入尾
//list1是一个遍历，一个记录遍历节点的前一个节点，以便插入。
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = list1, p1 = list1, p2 = list2;
        list1 = null;
        while(p1 != null && p2 != null){
            while(p2.next != null && p1 != null && p2.next.val <= p1.val)
                p2 = p2.next;
                if(p1 != null && p2 != null && p2.val <= p1.val){
                    ListNode tmp = p2.next;
                    p2.next = p1;
                    if(list1 == null){
                        list1 = list2;
                        head = list2;
                    }
                    else
                        list1.next = list2;
                    list1 = p1;
                    p1 = p1.next;
                    list2 = tmp;
                    p2 = tmp;
                }
            while(p1 != null && p2 != null && p2.val > p1.val){
                list1 = p1;
                p1 = p1.next;
            }
        }
        if(p2 != null && p1 == null)
            list1.next = p2;
        return head;
    }
}
//解法2：递归版本
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        if(list1.val < list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }
        else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
