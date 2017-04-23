package 剑指offer;
/*
 * 输入某二叉树的前序和中序遍历结果，重建该二叉树。
 * 假设：前序和中序遍历结果中不含重复数字。
 */
public class reconstructBinaryTree {
	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int x ) {
			val = x;
		}
	}
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null) return null;
        if(pre.length != in.length || pre.length == 0) return null;
        TreeNode t = new TreeNode(pre[0]);
        int i = 0;
        for(; i < in.length && in[i] != pre[0]; i++);
        if( 1 <= i)
            t.left = reConstructBinaryTree(java.util.Arrays.copyOfRange(pre, 1, i+1), java.util.Arrays.copyOfRange(in, 0, i));
        else 
           	t.left = null;
       	if( i+1 <= pre.length)
            t.right = reConstructBinaryTree(java.util.Arrays.copyOfRange(pre, i+1, pre.length), java.util.Arrays.copyOfRange(in, i+1, in.length));
    	else
            t.right = null;
        return t;
    }
}
