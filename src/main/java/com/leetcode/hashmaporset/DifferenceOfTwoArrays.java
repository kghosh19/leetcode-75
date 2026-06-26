package com.leetcode.hashmaporset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toSet());

        List<Integer> diff1 = s1.stream()
                .filter(n -> !s2.contains(n))
                .toList();

        List<Integer> diff2 = s1.stream()
                .filter(n -> !s1.contains(n))
                .toList();

        return List.of(diff1, diff2);
    }
}
