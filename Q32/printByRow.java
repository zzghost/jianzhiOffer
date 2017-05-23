/*
 *从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。 
 */

//解法：仍然是层次遍历，可以增加一个哨兵节点；也可以数出每一行的节点个数。

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null)
			return finalList;
		java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		TreeNode flag = new TreeNode(0);
		queue.offer(pRoot);
		queue.offer(flag);
		ArrayList<Integer> aList = new ArrayList<Integer>();
		while(queue.size() >= 2){
			TreeNode curr = queue.poll();
			if(curr.val == 0){
				queue.offer(flag);
				finalList.add(aList);
				aList = new ArrayList<Integer>();
			}
			else{
				aList.add(curr.val);
				if(curr.left != null)
					queue.offer(curr.left);
				if(curr.right != null)
					queue.offer(curr.right);
			}
		}
		finalList.add(aList);
		return finalList;
	}

}
