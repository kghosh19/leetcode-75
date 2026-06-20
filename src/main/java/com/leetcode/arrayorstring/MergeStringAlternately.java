package com.leetcode.arrayorstring;

public class MergeStringAlternately {
    void main() {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        int len = word1.length() >= word2.length() ? word2.length() : word1.length();
        StringBuilder word3 = new StringBuilder();
        int endIndex = 0;
        for(int i = 0; i < len; i++){
            word3.append(word1.charAt(i));
            word3.append(word2.charAt(i));
            endIndex = i + 1;
        }
        word3.append(word1.substring(endIndex));
        word3.append(word2.substring(endIndex));
        return word3.toString();
    }
}
