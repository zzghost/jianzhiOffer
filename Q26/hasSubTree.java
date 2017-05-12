/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */

//解法：层次遍历A，然后中序遍历匹配B。

public class Solution {
    public boolean inOrder(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null || t1.val != t2.val)
            return false;
        if(t2.left == null && t2.right == null)
            return true;
        return inOrder(t1.left, t2.left) && inOrder(t1.right, t2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        java.util.Queue<TreeNode> Q = new java.util.LinkedList<TreeNode>();
        Q.offer(root1);
        while(Q.peek() != null){
            TreeNode start = Q.poll();
            if(inOrder(start, root2))
                return true;
            else{
                if(start.left != null)
                    Q.offer(start.left);
                if(start.right != null)
                    Q.offer(start.right);
            }
        }
        return false;
    }
}
