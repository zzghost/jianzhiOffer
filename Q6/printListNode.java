package 剑指offer;
/*
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 */
public class printListNode {
	public static class ListNode{
		int val;
		ListNode next;
	}
	//解法：递归打印.也可以用栈存下来，这里不实现了。用递归可能产生的问题是，若链表非常长，函数调用的层级很深，
	//从而有可能导致函数调用栈溢出。
	public static void reversePrint(ListNode t){
		if(t == null) 
			return;
		else{
			reversePrint(t.next);
			System.out.println(t.val);
		}
	}
	public static ListNode create(int num){
		ListNode t = new ListNode();
		t.val = 1; t.next = null;
		ListNode p = t;
		for(int i = 1; i < num; i++){
			ListNode tmp = new ListNode();
			tmp.val = i+1; tmp.next = null;
			p.next = tmp;
			p = tmp;
		}
		return t;
	}
	public static void main(String[] args){
		ListNode t = create(5);
		reversePrint(t);
	}
}
