package com.leetcode.heaporpriorityqueue;

import java.util.PriorityQueue;

public class HireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        var headPq = new PriorityQueue<Integer>();
        var tailPq = new PriorityQueue<Integer>();
        int head = 0;
        int tail = costs.length - 1;

        long cost = 0;

        for(int i = 0; i < k; i++) {
            while(headPq.size() < candidates && head <= tail) {
                headPq.offer(costs[head++]);
            }
            while(tailPq.size() < candidates && head <= tail) {
                tailPq.offer(costs[tail--]);
            }

            int headMin = headPq.isEmpty() ? Integer.MAX_VALUE : headPq.peek();
            int tailMin = tailPq.isEmpty() ? Integer.MAX_VALUE : tailPq.peek();

            if(headMin <= tailMin) {
                cost += headMin;
                headPq.poll();
            }
            else {
                cost += tailMin;
                tailPq.poll();
            }
        }

        return cost;
    }
}
