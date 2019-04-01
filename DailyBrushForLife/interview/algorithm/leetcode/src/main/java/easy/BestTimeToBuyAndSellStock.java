package easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int min = 1000000;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){

            if(prices[i]-min>maxProfit){
                maxProfit = prices[i]-min;
            }
            if(prices[i]<min){
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
