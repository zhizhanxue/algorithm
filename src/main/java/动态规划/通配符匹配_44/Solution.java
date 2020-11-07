//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
//
//
// 两个字符串完全匹配才算匹配成功。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
//
//
// 示例 3:
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//
//
// 示例 4:
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//
//
// 示例 5:
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false
// Related Topics 贪心算法 字符串 动态规划 回溯算法
// 👍 555 👎 0
package 动态规划.通配符匹配_44;

public class Solution {

    //Time:O(m*n)   Space:O(m*n)
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return true;
        int plen = p.length(), slen = s.length();
        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;

        for (int i = 1; i <= plen && p.charAt(i - 1) == '*'; i++) dp[i][0] = true;

        for (int i = 1; i <= plen; i++) {
            for (int j = 1; j <= slen; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[plen][slen];
    }
    //思路:dp(i,j)定义为字符串p前i个字符匹配字符串s前j个字符
    //1.p.charAt(i-1) == s.charAt(j-1) || p.chatAt(i-1) == '?'          dp[i][j] = dp[i-1][j-1];
    //2.p.charAt(i-1) == '*'        dp[i][j] = dp[i-1][j] || dp[i][j-1]     dp[i-1][j]:*号匹配了空字符串，dp[i][j-1]:*号至少匹配了一个字符串
    //3.  dp[i][j] = false

}
