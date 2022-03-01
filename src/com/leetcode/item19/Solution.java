package com.leetcode.item19;

import com.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(new ListNode(head.val));
            head = head.next;
        }

        if (listNodes.size() == 1 && n == 1) {
            return null;
        }
        ListNode result = null;
        for (int i = 0; i < listNodes.size(); i++) {
            if (i == listNodes.size() - n) {
                continue;
            }
            if (result == null) {
                head = listNodes.get(i);
                result = head;
            } else {
                head.next = listNodes.get(i);
                head = head.next;
            }
        }
        return result;
    }

    /**
     * 快慢指针法
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = result;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }

}
