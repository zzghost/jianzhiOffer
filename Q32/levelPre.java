/*
 * 从上往下打印出二叉树的每个节点，
 * 同层节点从左至右打印。
 */
//
//解法：二叉树层次遍历。借助队列。无难度。
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(root == null) return aList;
        java.util.Queue<TreeNode> Q = new java.util.LinkedList<TreeNode>();
        Q.offer(root);
        while(Q.peek()!= null){
            TreeNode tmp = Q.poll();
            aList.add(tmp.val);
            if(tmp.left != null)
                Q.offer(tmp.left);
            if(tmp.right != null)
                Q.offer(tmp.right);
        }
        return aList;
    }
}
