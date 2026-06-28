package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeStrings {

    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
            }
            else if('[' == c) {
                numStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            }
            else if(']' == c) {
                StringBuilder decodedString = stringStack.pop();
                int n = numStack.pop();
                for (int i = 0; i < n; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }
            else
                currentString.append(c);
        }
        return currentString.toString();
    }
}
