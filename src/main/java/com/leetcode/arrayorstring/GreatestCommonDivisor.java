package com.leetcode.arrayorstring;

public class GreatestCommonDivisor {
    void main() {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        if(!str1.concat(str2).equals(str2.concat(str1)))
            return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        while(a % b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }
}
