/*
 * LL去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 * 为了方便起见,你可以认为大小王是0。
 *
 */


//步骤：１，排序；２，数出0的个数；３，数出前后两个数之间间隔多少，如果间隔小于等于0的话，意味着(可以用大小王来替代)构成顺子

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length < 5) return false;
        java.util.Arrays.sort(numbers);
        int count = 0;
        for(int i = 0; i < 5; i++)
            if(numbers[i] == 0)
                count++;
        int first = count;
        int second = first + 1;
        int gap = 0;
        while(second < numbers.length){
            if(numbers[second] == numbers[first])
                return false;
            gap += numbers[second] - numbers[first] - 1;
            first = second; second++;
        }
        return (gap <= count);
    }
}
