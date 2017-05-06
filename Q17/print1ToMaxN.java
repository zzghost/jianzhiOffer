package jianzhiOffer;
/*
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的三位数999.
 */

//解法1：若n非常大，则应该使用字符串存储数据
//这里主要有2个函数，一个是increment()，作用：数字的加1操作，O(1)时间复杂度判断是否到最后一位的操作；
//另一个是print()，作用：打印数字。
//
//解法2：java里边有bigInteger处理大整数。正式面试的时候肯定不能用这种方法。
//
//解法3：可以把这看成一个数字从0到9，一共n个数字的全排列问题。全部排一遍，不输出前边的0就可以。
//重点在掌握用递归来实现全排列。
public class print1ToMaxN{
    public static boolean increment(char[] a){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = a.length;
        for(int i = nLength - 1; i >= 0; i--){
            int nSum = a[i]-'0'+nTakeOver;
            if(i == nLength - 1)
                nSum++;
            if(nSum >= 10){
                if(i == 0)
                    isOverflow = true;
                else{
                    nSum -= 10;
                    nTakeOver = 1;
                    a[i] = (char)('0' + nSum);
                }
            }
            else{
                a[i] = (char)('0' + nSum);
                break;
            }
        }
    return isOverflow;
    }
    public static void print(char[] a){
        boolean isFirstZero = true;
        for(int i = 0; i < a.length; i++){
            if(isFirstZero && a[i] == '0')
                continue;
            isFirstZero = false;
            System.out.print(a[i]);
        }
        System.out.println();
    }
    //解法1
    public static void printMain(int n){
        if(n <= 0) return;
        char[] a = new char[n];
       java.util.Arrays.fill(a, '0');
        while(!increment(a))
            print(a);
    }
    //解法2
    public static void bigPrintMain(int n){
        if(n <= 0)  return;
        java.math.BigInteger big1 = new java.math.BigInteger("1");
        java.math.BigInteger addBig = java.math.BigInteger.ONE;
        char[] t = new char[n+1];
        java.util.Arrays.fill(t, '0');
        t[0] = '1';
        String tmp = String.valueOf(t);
        java.math.BigInteger overflow = new java.math.BigInteger(tmp);
        while(!big1.equals(overflow)){
            System.out.println(big1);
            big1 = big1.add(addBig);
        }
    }
    //解法3
    public static void printMainRecursively(char[] num, int n, int index){
    	if(index == n - 1){
    		print(num);
    		return;
    	}
    	for(int i = 0; i < 10; i++){
    		num[index + 1] = (char)(i + '0');
    		printMainRecursively(num, n, index + 1);
    	}
    }
    public static void printMainRe(int n){
    	if(n <= 0) return;
    	char[] num = new char[n];
    	for(int i = 0; i < 10; i++){
    		num[0] = (char)(i + '0');
    		printMainRecursively(num, n, 0);
    	}
    }
    public static void main(String[] args){
        int n = 3;
        //printMain(n);
        //bigPrintMain(n);
        printMainRe(n);
    }
}
