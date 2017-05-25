/*
 *输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

//解法：在遍历到当前节点时，把当前节点加入到path里边。
//如果当前节点是叶节点，且path相加已为target，加入到最终列表中。
//如果当前节点是叶节点，但path相加不为target，直接返回到父节点。
//无论找到path与否，都要在当前path里边删除当前节点，以寻找另一种可能性。
//

public class Solution {
    ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
    public void findPath(TreeNode node, ArrayList<Integer> aList, int target){
        aList.add(node.val);
        if(node.val == target && node.left == null && node.right == null){
            ArrayList<Integer> oneList = new ArrayList<Integer>();
            oneList.addAll(aList);
            finalList.add(oneList);
            return ;
        }
        if(node.left == null && node.right == null && node.val != target){ 
            return ;
        }
        if(node.left != null){
            findPath(node.left, aList, target-node.val);
            aList.remove(aList.size()-1);
        }
        if(node.right != null){
            findPath(node.right, aList, target-node.val);
            aList.remove(aList.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(root == null)
            return finalList;
        ArrayList<Integer> aList = new ArrayList<Integer>();
        findPath(root, aList, target);
        return finalList;
    }
}
