/*
 * @lc app=leetcode id=2260 lang=java
 *
 * [2260] Minimum Consecutive Cards to Pick Up
 */

// @lc code=start
class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int pickUp = Integer.MAX_VALUE;
        
        Map<Integer, ArrayList> track = new HashMap<>();
        
        for (int i = 0; i < cards.length; i++) {
            track.computeIfAbsent(cards[i], t -> new ArrayList<>()).add(i);
        }
        
        for (Map.Entry<Integer, ArrayList> entry : track.entrySet()) {
            int key = entry.getKey();
            List<Integer> indices = entry.getValue();
            
            if (indices.size() > 1){
                int firstValue = indices.get(0);
                
                for (int i = 1; i < indices.size(); i++) {
                    int diff = indices.get(i) - firstValue + 1;
                    pickUp = Math.min(pickUp, diff);
                    firstValue = indices.get(i);
                }
            }
        }
        
        return pickUp == Integer.MAX_VALUE ? -1 : pickUp;
        
    }
}
// @lc code=end

