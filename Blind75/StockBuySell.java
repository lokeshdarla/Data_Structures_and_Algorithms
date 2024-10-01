import java.util.HashMap;

public class StockBuySell {

  static int stockBuySell1(int prices[]) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      int currentProfit = prices[i] - minPrice;
      maxProfit = Math.max(maxProfit, currentProfit);
    }

    return maxProfit;
  }

  static int stockBuySell2(int[] prices) {
    int profit = 0;
    int n = prices.length;
    for (int i = 1; i < n; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }

  static int helper(int index, int buy, int cap, int prices[], HashMap<String, Integer> hMap) {
    if (index == prices.length || cap == 0) {
      return 0;
    }

    String key = index + "-" + buy + "-" + cap;
    if (hMap.containsKey(key)) {
      return hMap.get(key);
    }

    int profit;
    if (buy == 1) {
      profit = Math.max(-prices[index] + helper(index + 1, 0, cap, prices, hMap),
          helper(index + 1, 1, cap, prices, hMap));
    } else {
      profit = Math.max(prices[index] + helper(index + 1, 1, cap - 1, prices, hMap),
          helper(index + 1, 0, cap, prices, hMap));
    }

    hMap.put(key, profit);
    return profit;
  }

  static int stockBuySell3(int[] prices) {
    HashMap<String, Integer> hMap = new HashMap<>();
    return helper(0, 1, 2, prices, hMap);
  }

  public static void main(String[] args) {
    int[] prices = { 7, 1, 5, 3, 6, 4 };

    int profit1 = stockBuySell1(prices);
    System.out.println("Max Profit (Method 1): " + profit1);

    int profit2 = stockBuySell2(prices);
    System.out.println("Max Profit (Method 2): " + profit2);

    int profit3 = stockBuySell3(prices);
    System.out.println("Max Profit (Method 3): " + profit3);
  }
}
