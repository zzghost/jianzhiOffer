/*
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */

//解法：最普通的方法就是挨个计算。时间复杂度o(n^2)
//好的解法：将一个数组B看成是C和D的乘积，C和D都分别可以用递推表达式求出来

mport java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] C = new int[len];
        int[] D = new int[len];
        int[] B = new int[len];
        C[0] = 1;
        D[len-1] = 1;
        for(int i = 1; i < len; i++){
            C[i] = C[i-1] * A[i-1];
        }
        for(int i = len-2; i >= 0; i--){
            D[i] = D[i+1] * A[i+1];
        }
        for(int i = 0; i < len;i++)
            B[i] = C[i] * D[i];
        return B;
    }
}
