/*
 * @lc app=leetcode id=2034 lang=java
 *
 * [2034] Stock Price Fluctuation 
 */

// @lc code=start
class StockPrice {
    private int currentStockPrice;
    private int currentTimestamp;
    private final Map<Integer, Integer> timestampPrices;
    private final Map<Integer, Integer> occurrences;
    
    public StockPrice() {
        currentStockPrice = 0;
        currentTimestamp = 0;
        occurrences = new HashMap();
        timestampPrices = new HashMap();
    }
    
    public void update(int timestamp, int price) {
        if(timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
            currentStockPrice = price;
        }
        if(timestampPrices.containsKey(timestamp)) {
            int oldPrice = timestampPrices.get(timestamp);
            if(occurrences.get(oldPrice) == 1) {
                occurrences.remove(oldPrice);
            } else {
                occurrences.put(oldPrice, occurrences.get(oldPrice)-1);
            }
        }
        timestampPrices.put(timestamp, price);
        occurrences.put(price, occurrences.getOrDefault(price, 0)+1);
    }
    
    public int current() {
        return currentStockPrice;
    }
    
    public int maximum() {
        List<Integer> prices = new ArrayList(occurrences.keySet());
        Collections.sort(prices);
        return prices.get(prices.size()-1);
    }
    
    public int minimum() {
        List<Integer> prices = new ArrayList(occurrences.keySet());
        Collections.sort(prices);
        return prices.get(0);
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
// @lc code=end

