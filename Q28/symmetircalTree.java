/*
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

//解法：注意到对称，是原二叉树的前序遍历序列与二叉树的镜像的前序遍历序列一样。
public class Solution {
    boolean digui(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null)
            return true;
        if((p1 == null || p2 == null) || p1.val != p2.val)
            return false;
        return (digui(p1.left, p2.right) && digui(p1.right, p2.left));
    }
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null || pRoot.left == null && pRoot.right == null) return true;
            return digui(pRoot.left, pRoot.right);
    }
}
