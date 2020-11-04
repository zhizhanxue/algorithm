//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划
// 👍 634 👎 0
package 动态规划.三角形中的最小路径和_120;

import java.util.List;

public class Solution {

    //Time:O(n^2)       Space:O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0
                || triangle.get(0) == null || triangle.get(0).size() == 0)
            return 0;
        int size = triangle.size();
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) dp[i] = triangle.get(size - 1).get(i);

        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        }
        return dp[0];
    }
    //自底向上：dp(i,j)代表到达第i行，第j列的最小路径和
    //如果是最下层，数组里的元素即为最短路径
    //dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j); dp(0,0)即为最短路径和
    //i只依赖i+1,所以可以省略，j依赖j+1，所以应该正序遍历
}
