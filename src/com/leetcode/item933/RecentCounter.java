package com.leetcode.item933;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3001,3002};
        RecentCounter rc = new RecentCounter();
        for(int num :nums){
            System.out.println(rc.ping(num));
        }

    }

}
