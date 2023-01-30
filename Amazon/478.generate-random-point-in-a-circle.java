/*
 * @lc app=leetcode id=478 lang=java
 *
 * [478] Generate Random Point in a Circle
 */

// @lc code=start
class Solution {
    public Solution(double radius, double x_center, double y_center) {
      this.radius = radius;
      this.x_center = x_center;
      this.y_center = y_center;
    }
  
    public double[] randPoint() {
      final double length = Math.sqrt(Math.random()) * radius;
      final double degree = Math.random() * 2 * Math.PI;
      final double x = x_center + length * Math.cos(degree);
      final double y = y_center + length * Math.sin(degree);
      return new double[] {x, y};
    }
  
    private double radius;
    private double x_center;
    private double y_center;
  }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

