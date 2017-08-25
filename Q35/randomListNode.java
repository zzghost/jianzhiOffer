/*
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空)
 *
 */

//思路1：用一个hashmap存储random的对应关系。用空间换时间，时空复杂度均为o(n)
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode pre = pHead, newPre = newHead;
        map.put(pre, newPre);
        while(pre.next != null){
            newPre.next = new RandomListNode(pre.next.label);
            pre = pre.next;
            newPre = newPre.next;
            map.put(pre, newPre);
        }
        pre = pHead; newPre = newHead;
        while(newPre != null){
            newPre.random = map.get(pre.random);
            pre = pre.next;
            newPre = newPre.next;
        }
        return newHead;
    }
}
//思路２：不用hashmap，分三步；１）复制节点N，记为节点N'，将N'直接放在N后；２）N的random节点为S，则N'的random节点S'就在S.next；３）把复制的链表提取出来
//注意输出结果中返回参数不能是节点引用，要新建立节点。
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;

        RandomListNode p = pHead;
        while(p != null){
            RandomListNode tmp = new RandomListNode(p.label);
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
        }

        p = pHead;
        while(p != null){
            RandomListNode pNext = p.next;
            if(p.random != null)
                pNext.random = p.random.next;
            p = pNext.next;
        }

        RandomListNode newHead = null;
        RandomListNode cloneNode = null;
        RandomListNode pNode = pHead;
        if(pNode != null){
            newHead = pNode.next;
            cloneNode = pNode.next;
            pNode.next =  cloneNode.next;
            pNode = pNode.next;
        }
        while(pNode != null){
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }

        return newHead;
    }
}
