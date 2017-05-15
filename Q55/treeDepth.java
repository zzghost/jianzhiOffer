/*
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */

//递归求解
//
public class Solution {
    public int deep(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(deep(root.left), deep(root.right))+1;
    }
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return deep(root);
    }
}
