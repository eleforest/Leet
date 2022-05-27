package eleforest.leet;

/**
 * 长度n的数组1,2,3...n，重排列数组，要求每个位置与原来数字不同，且相同位置差的绝对值的和最小。
 * 给定n，输出最小的相同位置差的和。
 * 例如：输入 n=3，输出 sum=4
 * 1,2,3
 * 1,3,2 //非法
 * 2,3,1 //合法，差的和为4
 */
public class MinArrayDifferenceSum {
    public static int minDifference(int count){
        int diffSum;
        if (count%2 == 0){// 偶数
            diffSum = count;// 两两交换，每个位置相差都是1
        } else{ // 奇数
            diffSum = count + 1; // 从头开始两两交换，剩余最后一个位置n-1，这个位置与n-2 交换，最终多一个
        }
        return diffSum;
    }
}
