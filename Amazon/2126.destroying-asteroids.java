/*
 * @lc app=leetcode id=2126 lang=java
 *
 * [2126] Destroying Asteroids
 */

// @lc code=start
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
      Arrays.sort(asteroids);
  
      long m = mass;
  
      for (final int asteroid : asteroids)
        if (m >= asteroid)
          m += asteroid;
        else
          return false;
  
      return true;
    }
  }
// @lc code=end

