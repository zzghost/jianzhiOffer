package 剑指offer;
/*
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有左右子节点的指针，还有一个指向父节点的指针。
 */
public class getNext {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	/*
	 * 如果node有右子树：return 右子树里的最左节点；
	 * 若node无右子树：node是父节点的左节点：return 父节点
	 * 				　node是父节点的右节点：return 祖先节点中第一个不是右节点的节点的父节点
	 * 注意给定节点为根节点和中序遍历最后一个节点的情况
	 */
	public class Solution {
	    public TreeLinkNode GetNext(TreeLinkNode pNode){
	        if(pNode == null) return null;
	        if(pNode.right == null)
	            if(pNode.next != null && pNode.next.left == pNode)
	                return pNode.next;
	        	else{
	                while(pNode.next != null && pNode.next.right == pNode){
	                    pNode = pNode.next;
	                }
	                if(pNode.next == null)
	                    return null;
	                else
	                	return pNode.next;
	            }
	        else{
	            pNode = pNode.right;
	            while(pNode.left != null)
	                pNode = pNode.left;
	            return pNode;
	        }
	    }
	}
}
