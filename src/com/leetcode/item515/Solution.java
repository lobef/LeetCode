package com.leetcode.item515;


import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树的根节点root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 示例1：
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * <p>
 * 示例2：
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * <p>
 * 提示：
 * 二叉树的节点个数的范围是 [0,104]
 * -231<= Node.val <= 231- 1
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        des(result, root, 0);
        return result;
    }


    public static void des(List<Integer> result, TreeNode root, int curDeep) {
        if (curDeep == result.size()) {
            result.add(root.val);
        } else {
            result.set(curDeep, Math.max(result.get(curDeep), root.val));
        }

        if (root.left != null) {
            des(result, root.left, curDeep + 1);
        }

        if (root.right != null) {
            des(result, root.right, curDeep + 1);
        }
    }


}
