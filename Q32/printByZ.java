/*
 *请实现一个函数按照之字形打印二叉树
 *第一行从左到右，第二行从右到左。
 */

//解法1：用两个栈模拟。
//stack1存偶数行（打印从右到左的），这是上一层节点按照左子节点、右子节点的顺序存入的。
//stack2存奇数行（打印从左到右的），这是上一层节点按照右子节点、左子节点的顺序存入的。

//解法2：利用java里边linkedlist为双向链表的原理
//用迭代器。奇数层从左到右，偶数层是从右到左。



public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return finalList;
        java.util.Stack<TreeNode> stack1 = new java.util.Stack<TreeNode>();
        java.util.Stack<TreeNode> stack2 = new java.util.Stack<TreeNode>();
        ArrayList<Integer> aList = new ArrayList<Integer>();
        stack2.push(pRoot);
        boolean odd = true;
        while(!stack1.empty() || !stack2.empty()){
            if(odd){
                TreeNode curr = stack2.pop();
                aList.add(curr.val);
                if(curr.left != null)
                    stack1.push(curr.left);
                if(curr.right != null)
                    stack1.push(curr.right);
                if(stack2.empty()){
                    odd = !odd;
                    finalList.add(aList);
                    aList = new ArrayList<Integer>();
                }
            }
            else{
                TreeNode curr = stack1.pop();
                aList.add(curr.val);
                if(curr.right != null)
                    stack2.push(curr.right);
                if(curr.left != null)
                    stack2.push(curr.left);
                if(stack1.empty()){
                    odd = !odd;
                    finalList.add(aList);
                    aList = new ArrayList<Integer>();
                }
            }
        }
        return finalList;
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return finalList;
        ArrayList<Integer> aList = new ArrayList<Integer>();
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        TreeNode flag = null;
        queue.addLast(flag);
        queue.addLast(pRoot);
        boolean odd = true;
        while(queue.size() != 1){
            TreeNode curr = queue.removeFirst();
            if(curr == null){
                java.util.Iterator<TreeNode> iter = null;
                if(odd)
                    iter = queue.iterator();
                else
                    iter = queue.descendingIterator();
                odd = !odd;
                while(iter.hasNext()){
                    TreeNode tmp = (TreeNode)iter.next();
                    aList.add(tmp.val);
                }
                finalList.add(aList);
                aList = new ArrayList<Integer>();
                queue.addLast(null);
                continue;
            }
            if(curr.left != null)
                queue.addLast(curr.left);
            if(curr.right != null)
                queue.addLast(curr.right);
        }
        return finalList;
    }
}
