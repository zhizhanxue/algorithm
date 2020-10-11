package tree.二叉搜索树的数量_96;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// Related Topics 树 动态规划
// 👍 851 👎 0
public class Solution {

    //Time:O(n^2)      Space:O(n)
    public int numTrees(int n) {
        int[] d = new int[n];
        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int j = 0; j < i; j++) {
                num += d[j] * d[i - j - 1];
            }
            d[i] = num;
        }
        return d[n];
    }
    //思路:二叉搜索树的特点，每个节点的左孩子都小于根节点，每个节点的右孩子都大于根节点。
    //我们只需要关注每个根节点的左右有几个节点就好了。假设n个节点的二叉搜索树数量是G(n),f(n)是以n为跟节点的二叉搜索树个数。
    //G(n) = f(1) + f(2) +...+f(n-1)+f(n);
    //1<=i<=n       当以i为根节点时，f(i) = G(i-1) * G(n-i);
    //G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0);

    //递归写法，复杂度不会算....
    public int numTreesRecur(int n) {
        if (n == 0 || n == 1) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTreesRecur(i - 1) * numTreesRecur(n - i);
        }
        return sum;
    }

}
