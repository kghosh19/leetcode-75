package com.leetcode.twopointers;

public class WaterContainer {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;

        while(start < end) {
            int l = end - start;
            int h = height[start] < height[end] ? height[start] : height[end];
            int area = l * h;

            maxArea = Math.max(maxArea, area);

            if(height[start] < height[end]){
                start++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }
}
