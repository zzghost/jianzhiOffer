/*
 *
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。 
 *
 *
 *
 */

//解法：找规律。因为是后序遍历，所以先取根节点。利用
//BST左子节点都比根节点要小，右子节点都比根节点要大的原理，对之前的所有节点进行检索。

class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(sequence == null || len == 0) return false;
        if(len == 1) return true;
        int root = sequence[len - 1];
        int i = 0;
        while(sequence[i] < root && i < len - 1) i++;
        int j = i;
        while(sequence[j] > root && j < len - 1) j++;
        if(sequence[j] < root) return false;
        boolean left = true;
        if(0 < i)
            left = VerifySquenceOfBST(java.util.Arrays.copyOfRange(sequence, 0, i));
        boolean right = true;
        if(i < len - 1)
            right = VerifySquenceOfBST(java.util.Arrays.copyOfRange(sequence, i, j));
        return left && right;
    }
}
