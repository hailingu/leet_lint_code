// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1138.
// Date: 2019.7.29

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DeckRevealedIncreasing {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ans = new int[deck.length];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < deck.length; ++ i) {
            deque.add(i);
        }

        int i = 0;
        while (!deque.isEmpty()) {
            ans[deque.pollFirst()] = deck[i ++];
            if (!deque.isEmpty()) {
                deque.add(deque.pollFirst());
            }
        }
        return ans;
    }
}