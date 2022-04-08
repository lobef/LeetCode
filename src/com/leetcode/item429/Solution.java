package com.leetcode.item429;

import com.leetcode.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
        Solution s = new Solution();
        List<List<Integer>> result = s.levelOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(root.val));
        compute(result, new ArrayList<>(), root.children);
        return result;
    }

    private void compute(List<List<Integer>> result, List<Integer> level, List<Node> children) {
        if (children == null || children.size() <= 0) {
            return;
        }
        List<Node> child = new ArrayList<>();

        for (Node node : children) {
            level.add(node.val);
            if (node.children == null || node.children.size() <= 0) {
                continue;
            }
            child.addAll(node.children);
        }
        result.add(level);
        compute(result, new ArrayList<>(), child);
    }
}
