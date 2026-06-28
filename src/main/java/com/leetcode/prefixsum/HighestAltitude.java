package com.leetcode.prefixsum;

public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int sum = 0;
        for(int n : gain) {
            sum += n;
            maxAltitude = Math.max(maxAltitude, sum);
        }
        return maxAltitude;
    }
}
