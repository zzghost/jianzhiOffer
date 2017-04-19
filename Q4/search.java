package jianzhiOffer;
/*
 * 在二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。输入这样的
 * 一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class search {
//解法：从右上角开始检索。若n等于右上角数m，则返回；若n大于m，则在这一列里找；否则在前面的列同一行找
public static boolean find(int[][] nums, int n){
	boolean rst = false;
	int row = nums.length;
	int col = nums[0].length;
	if(row > 0 && col > 0){
		int rows = 0, cols = col - 1;
		while(rows < row && cols > 0){
			if(nums[rows][cols] == n){
				rst = true;break;
			}
			else{
				if(nums[rows][cols] > n)
					--cols;
				else
					++rows;
			}
		}
	}
	return rst;
}
public static void main(String[] args){
	int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11,15}};
	int n = 7;
	System.out.println(find(nums, n));
}
}
