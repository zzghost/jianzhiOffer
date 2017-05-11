/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

//解法1:递归版。中序遍历并交换。root可能为空。
//解法2:非递归版。借助队列进行层次遍历并交换。
public class Solution {
    public void exchange(TreeNode t){
        if(t.left == null && t.right == null) return;
        else{
            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = tmp;
            if(t.left != null)
                exchange(t.left);
            if(t.right != null)
                exchange(t.right);
        }
    }
    public void Mirror(TreeNode root) {
        if(root == null) return;
            exchange(root);
    }
}

public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        java.util.Queue<TreeNode> Q = new java.util.LinkedList<TreeNode>();
        Q.offer(root);
        while(Q.peek() != null){
            TreeNode t = Q.poll();
            if(t.left != null || t.right != null){
                TreeNode tmp = t.left;
                t.left = t.right;
                t.right = tmp;
                if(t.left != null)
                    Q.offer(t.left);
                if(t.right != null)
                    Q.offer(t.right);
            }
        }
    }
}
