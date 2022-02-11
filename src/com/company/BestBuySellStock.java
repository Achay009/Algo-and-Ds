package com.company;

public class BestBuySellStock {
    public static void solution(int [] prices){
        int max = 0;
        int buy = 0;
        int sell = 1;
        while(sell < prices.length){
            if (prices[buy] > prices[sell]){
                buy = sell;
            }else{
                int profit = prices[sell] - prices[buy];
                max = Math.max(profit, max);
            }

            sell++;
        }

        System.out.println("Best Buy Sell Stock : "+max);
    }
}
