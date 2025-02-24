public class StockBuySell01 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        StockBuySell01 obj = new StockBuySell01();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + obj.maxProfit(prices));
    }
}
