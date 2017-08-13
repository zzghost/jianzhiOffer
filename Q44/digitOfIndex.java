/*
 * 所有的数字（从0开始）被序列化成：012345678910111213..这样的字符串。
 * 第5位是5，第13位是1，第19位是4。
 * 写一个函数求第n位是哪个数字？
 */

//思路：0~9占1位，共1+9个数字；10~99占2位，共90个数字；100~999占3位，共900个数字
//举例说明,n=1001
//前10位为数0~9
//11~189位为数10~99
//190~1989位为数100~999
//n-190=811位.811/3=270，270+100=370,811%3=1，所以在370的第1位上，也即7
//
public class Q {
    public static int getNumOnBit(int num, int index){
        int length = (int) (Math.log10(num) + 1);
        if(length <= index)
            return -1;
        System.out.println("num is :" + num);
        for(int i = 0; i < length - index - 1; i++)
            num = num / 10;
        return num % 10;
    }
    public static int digitAtIndex(int n) {
        if(n == 0 || n < 10)
            return n;
        int rst = 0, i = 0;
        while(true){
            int bits = (int) Math.pow(10, i) * 9 * (i + 1);
            if(n <= bits){
                int num = n / (i + 1);
                int index = n % (i + 1);
                num += (int) Math.pow(10, i); 
                rst = getNumOnBit(num, index);
                break;
            }
            n -= bits;
            if(i == 0)
                n--;
            i++;
        }
        return rst;
    }
    public static void main(String[] args){
        int n = 1001;
        int number = digitAtIndex(n);
        System.out.println(number);
    }
}

