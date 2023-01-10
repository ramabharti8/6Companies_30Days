/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i ++) {
            HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j ++) {
                int d = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                if (!sums.containsKey(d)) {
                    sums.put(d, 1);
                }
                else {
                    sums.put(d, sums.get(d) + 1);
                }
            }
            for (Integer sum:sums.keySet()) {
                count += sums.get(sum) * (sums.get(sum) - 1);
            }
        }
        return count;
    }
}
// @lc code=end

