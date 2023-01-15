package com.example.demo.array.Best_Time_ToBuy_AndSell_Stock;

import org.junit.jupiter.api.Test;

public class Solution {

    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

    Find and return the maximum profit you can achieve.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1; i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                // you need to buy on i-1th day and sell on ith day
                int profit = prices[i]-prices[i-1];
                maxProfit+=profit;
            }
        }
        return maxProfit;
    }
    @Test
    public  void t(){
        int[]nums ={7,1,5,3,6,4};
        int result = maxProfit(nums);
        assert result==7;
        System.out.println(result);
    }

    /**
     * Time complexity : O(n). Single pass.
     *
     * Space complexity: O(1). Constant space needed.
     */
}
