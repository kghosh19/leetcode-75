package com.leetcode.hashmaporset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {


    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> occurenceMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Set<Long> uniqueFrequencies = new HashSet<>(occurenceMap.values());

        return occurenceMap.values().size() == uniqueFrequencies.size();
    }
}
