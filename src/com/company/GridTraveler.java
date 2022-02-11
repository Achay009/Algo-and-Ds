package com.company;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class GridTraveler {
    public static void solution(int m, int n)
    {
        Map<String, Integer> memo = new HashMap<>();
        int ans = gridTraveler(m,n, memo);
        System.out.println("The grid Traveler ans is :" + ans);
    }

    public static int gridTraveler(int m, int n, Map<String,Integer> memo)
    {
        String Key = m + "," + n;
        if (memo.containsKey(Key)) return memo.get(Key);
        if (m == 1 && n == 1  ) return 1;
        if (m == 0 || n == 0) return 0;
        int ans = gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo);
        memo.put(Key, ans) ;
        return memo.get(Key);
    }

}
