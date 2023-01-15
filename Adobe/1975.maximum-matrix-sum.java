/*
 * @lc app=leetcode id=1975 lang=java
 *
 * [1975] Maximum Matrix Sum
 */

// @lc code=start
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int c=0, min=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<=0) c++; 
                matrix[i][j]=Math.abs(matrix[i][j]);
                sum+=matrix[i][j];
                min=Math.min(min, matrix[i][j]);
            }
        }
        if(c%2==1) sum-=(2*min);
        return sum;
    }
}
// @lc code=end

