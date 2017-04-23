package 剑指offer;

import java.util.Arrays;

/*
 * 输入某二叉树的前序和中序遍历结果，重建该二叉树。
 * 假设：前序和中序遍历结果中不含重复数字。
 */
public class reconstructBinaryTree {
	static class binaryTreeNode{
		int val;
		binaryTreeNode left, right;
	}
	public static binaryTreeNode construct(int[] pre, int[] in){
		if(pre == null || in == null)	return null;
		if(pre.length != in.length || pre.length == 0 || in.length == 0)
			return null;
		int t = pre[0], i = 0;
		for(; i < in.length && in[i] != t; i++);
		binaryTreeNode tree = new binaryTreeNode();
		tree.val = t;
		int[] preLeft = (1 <= i)?Arrays.copyOfRange(pre, 1, i+1):null;
		int[] preRight = (i+1 <= pre.length)?Arrays.copyOfRange(pre, i+1, pre.length):null;
		int[] inLeft = (1 <= i)?Arrays.copyOfRange(in, 0, i):null;
		int[] inRight = (i+1 <= in.length)?Arrays.copyOfRange(in, i+1, in.length):null;
		tree.left = construct(preLeft, inLeft);
		tree.right = construct(preRight, inRight);
		System.out.println(tree.val);
		return tree;
	}
	public static void pro(binaryTreeNode t){
		if(t == null) return;
		if(t.left != null) pro(t.left);
		if(t.right != null) pro(t.right);
		System.out.println(t.val);
	}
	public static void main(String[] args){
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		binaryTreeNode t = construct(pre, in);
	}
}
