/*
 * 一个链表中包含环，找出该环的入口节点
 */
//解法1:首先想到用java里的HashSet。时间复杂度o(n),空间复杂度o(n)
//解法2:用两个指针，一个快指针，一个慢指针。
//      步骤如下：
//      1）快指针走两步，慢指针走一步。终止：快指针==慢指针
//      2）计算环里边节点个数n。慢指针走一圈。
//      3）从头节点开始，快指针走

//解法1
public class Solution1{
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null) return null;
        if(pHead.next == pHead) return pHead;
        java.util.Set s = new java.util.HashSet();
        ListNode p = pHead;
        while(p != null && !s.contains(p.val)){
            s.add(p.val);
            p = p.next;
        }
        return p;
    }
}
//解法2:
public class Solution2 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null) return null;
        if(pHead.next == pHead) return pHead;
        ListNode fast = pHead, slow = pHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == slow && fast != null){
            slow = slow.next;
            int cnt = 1;
            while(slow != null && slow != fast){
                slow = slow.next;
                cnt++;
            }
            fast = pHead;
            slow = pHead;
            for(int i = 0; i < cnt; i++){
                fast = fast.next;
            }
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;                                                                                                                                                                                                 }
        else
            return null;
    }
}
