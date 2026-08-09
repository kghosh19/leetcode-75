package com.leetcode.twopointers;

public class Subsequence {

    void main() {
        String s = "abc", t = "ahbgdc";
        IO.println(isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;

        while(sp < s.length() && tp < t.length()) {

            if(s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();
    }
}
