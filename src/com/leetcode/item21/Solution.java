package com.leetcode.item21;

import com.leetcode.common.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 */
public class Solution {

    public static void main(String[] args) {
        ListNode result = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5)))),
                new ListNode(2, new ListNode(5, new ListNode(7, new ListNode(10)))));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return result.next;
    }

}
