/*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

//我的解法：无视了array[mid]==array[high]==array[low]这种情况，修改版的二分查找
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len == 0) return 0;
        if(len == 1) return array[0];
        int low = 0, high = len - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(high - low == 1 && array[high] <= array[low])
                return array[high];
            else if(array[mid] <= array[low] && array[mid] <= array[high])
                high = mid;
             else if(array[mid] >= array[low] && array[mid] >= array[high])
                low = mid;
        }
        return 0;
     }
}
