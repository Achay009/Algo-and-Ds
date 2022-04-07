package com.company;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class MinDeletionsToMakeCharactersFreqUnique {
    public static void solution(String s)
    {
        int [] alphabet = new int [26];
        s = s.toLowerCase(Locale.ROOT);
        for (char c : s.toCharArray()){
            alphabet[c - 'a']++;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : alphabet) {
            if (num != 0) {
                while (num != 0 && set.contains(num)) {
                    res++;
                    num--;
                }
                set.add(num);
            }
        }

        System.out.println(" The minimum number to delete to make characters unique : " + res);

    }
}
