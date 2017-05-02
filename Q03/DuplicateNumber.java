package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
长度为n的数组里的所有数字都在0~n-1范围内，请找出所有重复的数字
不知道有几个数字重复，也不知道每个数字重复几次
*/

//边界检查：１）数字是否在0~n-1范围内；2）数组长度
public class DuplicateNumber {
	//解法1:排序后扫描，时间复杂度O(nlogn)，空间复杂度O(1)
	public static ArrayList<Integer> findDuplicate1(int[] numbers){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		Arrays.sort(numbers);
		int tmp = numbers[0];
		for(int i = 1, j = 0; i < numbers.length; i++){
			if(tmp != numbers[i])
				tmp = numbers[i];
			else{
				if (!rst.contains(tmp))
					rst.add(tmp);
			}
		} 
		return rst;
	}

	//解法2：使用HashMap，时间复杂度O(n)，空间复杂度O(n)
	public static ArrayList<Integer> findDuplicate2(int[] numbers){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		Map<Integer, Integer> s = new HashMap<Integer, Integer>();
		int i = 0;
		for(int x : numbers){
			if(s.containsValue(x) && !rst.contains(x))
				rst.add(x);
			else{
				s.put(i, x);i++;
			}
		}
		return rst;
	}
	
	/*解法3：在原数组上做改动，时间复杂度o(n)，空间复杂度o(1)
	具体方法：利用数字范围0~n-1与数组索引0~n-1对应这个原则，从头扫描数组，将索引为i与当前数字m做比较，
	若i==m:索引下移
	若i!=m:比较m与num[m]，若m!=num[m]，交换，使num[m]=m；若m==num[m]，说明有重复*/
	public static ArrayList<Integer> findDuplicate3(int[] numbers){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		int l = numbers.length, i = 0;
		while(i < l){
			int m = numbers[i];
			while(m != i){
				if(m ==numbers[m] && !rst.contains(m)){
					rst.add(m);	break;
				}
				else{
					numbers[i] = numbers[m];
					numbers[m] = m;
					m = numbers[i];
				}
			}
			i++;
		}
		return rst;
	}
	public static void SPrint(ArrayList<Integer> al){
		for(int x : al){
			System.out.print(x + " ");
		}
	}
	public static void main(String[] args){
		int[] numbers = {2, 3, 1, 0, 2, 5, 3};
		//ArrayList<Integer> rst1 = findDuplicate1(numbers);
		//ArrayList<Integer> rst2 = findDuplicate2(numbers);
		ArrayList<Integer> rst3 = findDuplicate3(numbers);
		SPrint(rst3);
	}
}
