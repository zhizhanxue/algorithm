package tree.二叉搜索树中删除节点_450;
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。
//
// 一般来说，删除节点可分为两个步骤：
//
//
// 首先找到需要删除的节点；
// 如果找到了，删除它。
//
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
// 示例:
//
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
//
// Related Topics 树
// 👍 299 👎 0


import tree.structure.TreeNode;

public class Solution {

    //Time:O(n)     Space:O(n)      n为树的高度
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        if (root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode leftMax = root.left;
            while (leftMax.right != null) leftMax = leftMax.right;
            leftMax.right = root.right;
            return root.left;
        }

        return root;
    }

    //思路
    //递归    深度优先
    //搜索树的特性，任一节点的值都大于左子树，小于右子树
    //      1.当前节点比key大，在左子树上找；比key小，在右子树上找
    //      2.节点和key相等，如果有任意一边为null，直接返回另一边。
    //              否则，找寻左子树最大的值，将节点的右子树挂靠在左子树最大的节点下。
    //              反之寻找右子树最小的值，将节点的左子树挂靠在右子树最小的节点下


}
