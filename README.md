# 剑指offer(Java版)
## 题目合集
### 链表
No.|Title  
---|-----  
Q06|从尾到头打印链表  
Q18|删除链表的节点  
Q22|链表的倒数第k个节点  
Q23|链表中环的入口节点  
Q24|反转链表  
Q25|合并两个有序链表  
Q35|复杂链表的复制  
Q52|两个链表的第一个公共节点  
### 树  
No.|Title  
---|-----  
Q07|重建二叉树  
Q08|二叉树的下一个节点  
Q26|树的子结构  
Q27|二叉树的镜像  
Q28|对称的二叉树  
Q32|从上到下打印二叉树(二叉树层次遍历，按行打印二叉树，按之字形打印二叉树)  
Q33|二叉搜索树的后序遍历序列  
Q34|二叉树中和为某一值的路径  
Q36|二叉搜索树与双向链表  
Q37|序列化二叉树  
Q54|二叉搜索树的第k大节点  
Q55|二叉树的深度  
Q68|树中两个节点的最低公共祖先  
### 字符串与数组  
No.|Title  
---|-----  
Q03|数组中的重复数字(0~n-1若干数字重复若干次，1~n范围的数字至少有一个重复若干次)  
Q04|二维数组中的查找  
Q05|替换空格(合并排序数组,替换字符串中的空格)  
Q11|旋转数组的最小数字  
Q12|矩阵中的路径  
Q13|机器人的运动范围  
Q17|打印从1到最大的n位数  
Q19|正则表达式匹配  
Q20|表示数值的字符串  
Q21|调整数组顺序使奇数位于偶数前面  
Q29|顺时针打印矩阵  
Q38|字符串的排列  
Q39|数组中出现次数超过一半的数字  
Q40|最小的k个数  
Q41|数据流中的中位数  
Q42|连续子数组的最大和  
Q43|1~n整数中1出现的次数  
Q44|数字序列中某一位的数字  
Q45|把数组排成最小的数  
Q46|把数字翻译成字符串  
Q51|数组中的逆序对  
Q53|在排序数组中查找数字
Q56|数组中数字出现的次数  
Q57|和为s的两个数  
Q58|反转字符串  
Q67|把字符串转化成整数  
Q66|构建乘积数组  
### 栈和队列  
No.|Title  
---|-----  
Q09|用两个栈实现队列  
Q30|包含min函数的栈  
Q31|栈的压入、弹出序列  
Q59|队列的最大值  
### 其他  
No.|Title|Other  
---|-----|-----  
Q10|斐波那契(斐波那契变形，青蛙跳台阶问题，矩形覆盖问题)|  
Q14|剪绳子|动态规划  
Q15|二进制中1的个数|位运算  
Q16|数值的整数次方|
Q47|礼物的最大价值|动态规划  
Q48|最长不含重复字符的子字符串|动态规划  
Q49|丑数|堆  
Q50|第一个只出现一次的字符|哈希表  
Q60|n个骰子的点数|动态规划  
Q61|扑克牌中的顺子|数学建模  
Q62|圆圈中最后剩下的数字|数学建模  
Q63|股票的最大利润|动态规划  
Q64|求1+2+..+n|面向对象基础  
Q65|不用加减乘除做加法|位运算  

## 读书心得
读到第二章与第三章的开头，做了10来道题，发现写代码除了实现基本功能之外，最重要的是程序的鲁棒性。代码的完整性包含三个部分：  
*   功能测试：代码可以实现基本的功能
*   边界测试：循环的边界、递归的边界、int,float等类型的边界
*   负面测试：当输入不符合要求的数据时，怎么处理这些输入
平时写程序的时候，就要养成考虑这三个部分的习惯。处理这三个错误的时候，通常有一些做法：
*   返回值：不能方便地使用计算结果
*   全局变量：用户可能会忘记检查全局变量
*   异常  

5.23更新：  
最近刷题发现了一些问题：自以为掌握了算法，但写起来却不熟练，导致实际当中看到题以后也仍然不懂得怎么处理。  
在做题时如果想不出来，可以用画图、举例，多次模拟，也许就有思路了。像二叉树相关的题，如果是遍历类的，则一般都是想到分治，递归。  
