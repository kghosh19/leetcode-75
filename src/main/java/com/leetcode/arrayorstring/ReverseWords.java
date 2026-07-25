package com.leetcode.arrayorstring;

public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder sbr = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0) {
            while(i >= 0 && s.charAt(i) == ' ')
                i--;
            if(i < 0)
                break;

            int j = i;

            while(i >= 0 && s.charAt(i) != ' ')
                i--;

            if(sbr.length() > 0)
                sbr.append(" ");

            sbr.append(s.substring(i+1, j+1));
        }
        return sbr.toString();
    }
}
