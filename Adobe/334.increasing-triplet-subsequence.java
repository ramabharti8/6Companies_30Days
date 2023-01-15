/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
            
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
            
        for (int num : nums) {
            if (num < minOne) {
                minOne = num;
            }
                
            if (num > minOne) {
                minTwo = Math.min(num, minTwo);
            }
              
            if (num > minTwo) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

