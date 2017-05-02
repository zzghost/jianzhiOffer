package jianzhiOffer;
/*
 * 求斐波那契数列的第n项
 */
/*
 * 解法：
 * 1，递归（但不推荐，因为它虽然直观，可是时间效率太低）
 * 2，由于方法1涉及大量重复计算，所以第二种方法为递推，减少重复计算，时间复杂度o(n)
 * 3，变成矩阵的乘方，公式(f(n) f(n-1)\n f(n-1) f(n-2))=(1 1\n1 0)的(n-1)次方。
 * 从0次方开始计算，总共要算n次，时间复杂度仍然是o(n)。
 * 现在改进它，已知乘方有性质：a(n次方) = a(n/2)*a(n/2)(n为偶数)或a(n-1/2)*a(n-1/2)*a(n为奇数)
 * 利用递归求解上式，时间复杂度为o(logn)
 */

public class fibonacci {
	//普通方法
	public class Solution1 {
	    public int Fibonacci(int n) {
	        if(n == 0) return 0;
	        if(n == 1) return 1;
	        int last1 = 0, last2 = 1;
	        int rst = 0;
	        for(int i = 2; i <= n; i++){
	            rst = last1 + last2;
	            last1 = last2;
	            last2 = rst;
	        }
	        return rst;
	    }
	}
	//矩阵乘法求斐波那契第n项
	public class Solution2 {
	    public int[][] multiply(int[][] matrix1, int[][] matrix2){
	        int row = matrix1.length;
	        int col = matrix2[0].length;
	        int mid = matrix2.length;
	        int[][] rst = new int[row][col];
	        for(int i = 0; i < row; i++){
	            for(int j = 0; j < col; j++){
	                for(int k = 0; k < mid; k++){
	                    rst[i][j] += matrix1[i][k] * matrix2[k][j]; 
	                }
	            }
	        }
	        return rst;
	    }
	   	public int[][] digui(int[][] a, int num){
	        int[][] I = new int[][]{{1, 0}, {0, 1}};
	        if( num == 0) return I;
	        int[][] t = a;
	        a = I;
	        for(int i = 1; i <= num; i++)
	            a = multiply(a, t);
	        return a;
	        
	    }
	    public int Fibonacci(int n) {
	        if(n == 0) return 0;
	        if(n == 1) return 1;
	        int[][] F = new int[2][2];
	        F[1][1] = 0;
	        F[1][0] = 1;
	        F[0][1] = 1;
	        F[0][0] = 1;
	        int num = ((n-1)%2==0)?((n-1)/2) :((n-2)/2);
	        int[][] a = F;
	        int[][]rst = digui(a, num);
	       	rst = digui(rst, 2);
	        if((n-1)%2!=0)
	            rst = multiply(rst, a);
	        return rst[0][0];
	    }
	}
}
