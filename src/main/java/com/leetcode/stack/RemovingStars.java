package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class RemovingStars {

    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && c == '*') {
                stack.pop();
            }
            else
                stack.push(c);
        }
        StringBuilder sbr = new StringBuilder();
        while(!stack.isEmpty()) {
            sbr.append(stack.pop());
        }

        return sbr.reverse().toString();
    }
}
