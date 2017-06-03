/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

//解法：递归求左右子树的深度，然后递归判断左右子树是不是平衡。
public class Solution {
    public int deep(TreeNode t){
        if(t == null) return 0;
        if(t.left == null && t.right == null) return 1;
        return Math.max(deep(t.left), deep(t.right))+1;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int left = deep(root.left);
        int right = deep(root.right);
        int diff = left - right;
        if(Math.abs(diff) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}
