/*用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class Solution {
     public int RectCover(int target) {
         if(target == 0) return 0;
         if(target == 1) return 1;
         int rst = 0, lst1 = 0, lst2 = 1;
         for(int i = 1; i <= target; i++){
             rst = lst1 + lst2;
             lst1 = lst2;
             lst2 = rst;
         }
         return rst;
     }
}
