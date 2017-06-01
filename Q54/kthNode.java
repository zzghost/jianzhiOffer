/*
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */

//解法：实质就是考察中序遍历

public class Solution {
    public int count = 0;
    TreeNode fNode = new TreeNode(Integer.MAX_VALUE);
    void findNode(TreeNode node, int k){
        if(k <= 0) return ;
        if(node.left != null)
            findNode(node.left, k);
        count++;
        if(count == k){
            fNode = node;
            return;
        }
        if(node.right != null)
            findNode(node.right, k);
    }
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0) return null;
        findNode(pRoot, k);
        if(fNode.val == Integer.MAX_VALUE)
            fNode = null;
        return fNode;
    }
}
