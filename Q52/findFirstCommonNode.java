/*
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 */

//解法1:我用了java里的set集合，遇到冲突则返回该节点。时间o(m+n)，空间o(m+n)
//解法2:仍然是借助空间，用2个栈分别存节点，然后出栈比较，最后一个相同节点。（不写了）
//解法3:先计算两个链表长度，长的那个链表的指针先走差值步，然后一起遍历，第一个相同节点。

//1
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        java.util.Set set = new java.util.HashSet();
        while(pHead1 != null && pHead2 != null){
            if(!set.contains(pHead1.val))
                set.add(pHead1.val);
            else return pHead1;
                if(!set.contains(pHead2.val))
                    set.add(pHead2.val);
                else return pHead2;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
         }
        while(pHead1 != null){
            if(!set.contains(pHead1.val))
                set.add(pHead1.val);
            else return pHead1;
                pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            if(!set.contains(pHead2.val))
                set.add(pHead2.val);
            else return pHead2;
                pHead2 = pHead2.next;
        }
        return null;
    }
}

//3:
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1, p2 = pHead2;
        int len1=0, len2=0;
        while(p1 != null){
            p1 = p1.next;
            len1++;
        }
        while(p2 != null){
            p2 = p2.next;
            len2++;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(len1 > len2){
            for(int i = 0; i < len1 - len2; i++)
                p1 = p1.next;
        }
        else{
            for(int i =0; i < len2 - len1; i++)
                p2 = p2.next;
        }
        while(p1 != null && p2 != null){
            if(p1.val == p2.val)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
