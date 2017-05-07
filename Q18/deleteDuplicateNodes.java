/*
 * 删除链表中重复的节点。（重复节点不出现在要返回的链表中）
 */

//解法：三个指针，一个指向待返回链表的表尾，另外两个指针m和n用来遍历原链表，进行判断。
//要注意的是null的node检查。
public class Solution {
     public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return null;
        ListNode p = null, m = pHead, n = pHead;
        if(pHead.next == null)  return pHead;
        ListNode start = null;
        while(n != null && n.next != null){
            n = n.next;
            if(n.val == m.val)
            while(n != null && n.val == m.val)
                n = n.next;
            else{
                if(p == null)
                    start = m;
                else
                    p.next = m;
                p = m;
            }
            m = n;
        }
        if(m != null && m.next == null){
            if(p == null)
                start = m;
            else
                p.next = m;
        }
        else{
            if(p != null)
                p.next = null;
        }
        return start;
    }
}
