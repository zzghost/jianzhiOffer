package 剑指offer;

import java.util.ArrayList;

/*不修改数组，找出重复数字
 * 数字范围：1~n，数组长度n+1（说明数字至少有一个是重复的）
 * */
public class DuplicateNumber2 {
	//解法１：开辟一个n大小的数组，按照索引复制进去。时间复杂度o(n),空间复杂度o(n)
	public static ArrayList<Integer> duplicate(int[] numbers){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		int n = numbers.length;
		int[] tmp = new int[n];
		for(int x : numbers){
			if(tmp[x] == x && !rst.contains(x))
				rst.add(x);
			else tmp[x] = x;
		}
		return rst;
	}
	//解法2：书上的代码不能找出所有的重复数字。我觉得不是很好。改编他的代码，这里利用二分查找+分治的思想。
	//时间复杂度O(nlogn)，空间复杂度O(1)
	public static int rangeCount(int[] numbers, int start){
		int count = 0;
		int l = numbers.length;
		for(int i = 0; i < l; i++)
			if(numbers[i] == start)
				count++;
		return count; 
	}
	public static void solve(int[] numbers, int start, int end, ArrayList<Integer> rst){
		if(start != end) return;
		int count = rangeCount(numbers, start);
		if(count > 1 && !rst.contains(start)){
			rst.add(start);return ;
		}
	}
	public static void duplicate2(int[] numbers, int start, int end, ArrayList<Integer> rst){
		if(start < end){
			int mid = (end - start)/2 + start;
			duplicate2(numbers, start, mid, rst);
			duplicate2(numbers, mid+1, end, rst);
		}
		if(start == end)
			solve(numbers, start, end, rst);
	}
	
	//print
	public static void SPrint(ArrayList<Integer> rst){
		for (int x : rst){
			System.out.print(x + " ");
		}
	}
	public static void main(String[] args){
		int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
		ArrayList<Integer> rst2 = new ArrayList<Integer>();
		duplicate2(numbers, 1, numbers.length-1, rst2);
		SPrint(rst2);
	}
}
