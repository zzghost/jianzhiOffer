/*
 * 给定一个数字，0翻译成a,1成b,以此类推,25成z。。
 * 求给定一个数字可能有多少种翻译。
 * 例如12258可能有5种：bccfi,bwfi,bczi,mcfi,mzi
 */

//常规思路就是递归求解，自上而下解决。判断一个字符与后一个字符范围在不在10~25之中，重复子问题。
//最小子问题也可以从下而上解决。以消除重复子问题。

//Solution1:
public class Q {
    public static int count = 0;
    public static void Count(String str){
        if(str.length() == 0 || str.length() == 1){
            count++;
            return ;
        }
        char[] ch = str.toCharArray();
        if(ch[0] >= '0' && ch[0] <= '1' || (ch[0] == '2' && ch[1] >= '0' && ch[1] <= '5')){
            String st1 = str.substring(1, str.length());
            Count(st1);
            String st2 = str.substring(2, str.length());
            Count(st2);
        }
        else{
            String st = str.substring(1, str.length());
            Count(st);
        }
    }

    public static void main(String[] args){
        String str = "12658";
        Count(str);
        System.out.println(count);

    }
}

//Solution2
public class Q {
    public static boolean isNum(char first, char second){
        if(first == '2' &&  second <= '5' && second >= '0')
            return true;
        if(first == '1' && second >= '0' && second <= '9')
            return true;
        if(first == '0' && second >= '0' && second <= '9')
            return true;
        return false;
    }
    public static int Count(String str){
        int count = 0;
        int len = str.length();
        char[] ch = str.toCharArray();
        int[] cnt = new int[len];
        cnt[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--){
            if(isNum(ch[i], ch[i+1])){
                cnt[i] = cnt[i + 1] + cnt[i + 2];
            }
            else{
                cnt[i] = cnt[i + 1];
            }
        }
        count = cnt[0];
        return count;
    }

    public static void main(String[] args){
        String str = "12658";
        int count = Count(str);
        System.out.println(count);

    }
}

