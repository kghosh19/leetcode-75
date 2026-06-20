package com.leetcode.arrayorstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class KidsWithGreatestNumberOfCandies {
    void main() {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //int max = Arrays.stream(candies).max().getAsInt();
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        var bools = new ArrayList<Boolean>();
        for(int cn: candies) {
            bools.add((cn + extraCandies) >= max);
        }
        return bools;
    }
}
