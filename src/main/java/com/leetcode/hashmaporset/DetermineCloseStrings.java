package com.leetcode.hashmaporset;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DetermineCloseStrings {


    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if(len1 != len2)
            return false;

        Set<Character> s1 = word1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        Set<Character> s2 = word2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        if(!s1.equals(s2))
            return false;

        Map<Character, Long> m1 = word1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Map<Character, Long> m2 = word2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        List<Long> l1 = new ArrayList<>(m1.values());
        List<Long> l2 = new ArrayList<>(m2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}
