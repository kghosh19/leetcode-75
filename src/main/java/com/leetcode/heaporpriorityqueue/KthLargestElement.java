package com.leetcode.heaporpriorityqueue;

import java.util.PriorityQueue;

public class KthLargestElement {

    void main() {
        int[] nums = {3,2,1,5,6,4};

        var pq = new PriorityQueue<Integer>();
        for(int n: nums) {
            pq.offer(n);
        }
        while(!pq.isEmpty())
            IO.println(pq.poll());
    }


    public int findKthLargestOptimum(int[] nums, int k) {
        var queue = new PriorityQueue<Integer>();
        for(int n: nums) {
            queue.offer(n);

            if(queue.size() > k)
                queue.poll();
        }

        return queue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        var queue = new PriorityQueue<Integer>((a,b) -> b - a);
        for(int n: nums)
            queue.offer(n);
        for(int i = 0; i < k - 1; i++)
            queue.poll();

        return queue.poll();
    }
}
