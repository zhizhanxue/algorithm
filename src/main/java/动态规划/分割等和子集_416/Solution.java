package 动态规划.分割等和子集_416;
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意:
//
//
// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200
//
//
// 示例 1:
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
//
//
//
// 示例 2:
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
//
//
//
// Related Topics 动态规划
// 👍 577 👎 0
public class Solution {

    //Time:O(n*s)  Space:O(s)
    //n为nums数组的长度，s为nums的和半值
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;

        int n = nums.length, m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= nums[i - 1]; j--) {
                dp[j] = j == nums[i - 1] || dp[j] || dp[j - nums[i - 1]];
            }
            if (dp[m]) return true;
        }

        return false;
    }
    //思路:给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    //1.如果和值为奇数，则不可能出现两个子集相等
    //2.对问题做个转换，是否可以从数组中挑选出一些正整数，使得它们的和等于整个元素和的一半
    //定义状态d[i][j]为前i个数，其目标和为j的组合是否存在
    //dp[i][j] = d[i-1][j] || j == nums[i-1] || dp[i-1][j-nums[i]]
    //本质上是一个0/1背包的变体问题，每个状态值只依赖于上方的和左上方的值，采用逆向遍历可以对空间优化

}
