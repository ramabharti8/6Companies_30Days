/*
 * @lc app=leetcode id=1503 lang=java
 *
 * [1503] Last Moment Before All Ants Fall Out of a Plank
 */

// @lc code=start
class Solution {
    public int getLastMoment(int n, int[] left, int[] right)
    {
        int ans=Integer.MIN_VALUE;
        
        if(left.length>0)
        {
            for(int i:left)
            {
                ans=Math.max(ans,i);
            }
        }
        
        if(right.length>0)
        {
            for(int i:right)
            {
                ans=Math.max(ans,n-i);
            }
        }
        return ans;
    }
}
// @lc code=end

