package com.leetcode.slidingwindow;

public class MaxAverageSubArrayI {

        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;

            // 1. Calculate the first window
            for(int i = 0; i < k; i++) {
                sum += nums[i];
            }

            int maxSum = sum;

            // 2. Slide the window using a single pointer
            for(int i = k; i < nums.length; i++) {
                sum += nums[i] - nums[i - k]; // Add new element, remove the oldest element

                // 3. Avoid Math.max overhead
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }

            return (double) maxSum / k;
        }

}
