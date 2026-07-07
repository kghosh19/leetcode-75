package com.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {

    void main() {

    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque();
        Queue<Integer> dire = new ArrayDeque();
        int n = senate.length();

        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') {
                radiant.offer(i);
            }
            else
                dire.offer(i);
        }

        while(!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if(rIndex < dIndex) {
                radiant.offer(rIndex + n);
            }
            else {
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
