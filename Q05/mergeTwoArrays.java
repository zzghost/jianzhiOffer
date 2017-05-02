package 剑指offer;
/*
 * 两个排序的数组A1,A2，内存在A1的末尾有足够多余的空间容纳A2;
 * 请实现一个函数，把A2中的所有数字插入A1中，并且所有的数字都是排序的
 */
public class mergeTwoArrays {
	//解法：从尾到头比较A1和A2的数字，把较大的复制到A1中合适的位置
	public static int[] merge(int[] a1, int[] a2, int l1){
		int l2 = a2.length;
		int i = l1 - 1, j = l2 -1, k = l1 + l2 - 1;
		while(i >= 0 && j >= 0 && k >= 0){
			if(a1[i] > a2[j]){
				a1[k] = a1[i];
				i--;
			}
			else{
				a1[k] = a2[j];
				j--;
			}
			if(k>0)
				k--;
		}
		while(j >= 0){
			a1[k] = a2[j];
			k--;j--;
		}
		return a1;
	}
	public static void SPrint(int[] a1){
		for(int x: a1){
			System.out.print(x + " ");
		}
	}
	public static void main(String[] args){
		int[] a1 = new int[]{1,6,9,10,15,0,0,0,0,0,0,0,0,0,0,0};
		int[] a2 = new int[]{2,3,5,7,8,13,17,18};
		a1 = merge(a1, a2, 5);
		SPrint(a1);
	}
}
