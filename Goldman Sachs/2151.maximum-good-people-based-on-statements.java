/*
 * @lc app=leetcode id=2151 lang=java
 *
 * [2151] Maximum Good People Based on Statements
 */

// @lc code=start
class Solution {
    public int maximumGood(int[][] statements) {
      dfs(statements, new ArrayList<>(), 0, 0);
      return ans;
    }
  
    private int ans = 0;
  
    private void dfs(int[][] statements, List<Integer> good, int i, int count) {
      if (i == statements.length) {
        if (isValid(statements, good))
          ans = Math.max(ans, count);
        return;
      }
  
      good.add(0); // Assume i-th person is bad
      dfs(statements, good, i + 1, count);
      good.set(good.size() - 1, 1); // Assume i-th person is good
      dfs(statements, good, i + 1, count + 1);
      good.remove(good.size() - 1);
    }
  
    private boolean isValid(int[][] statements, List<Integer> good) {
      for (int i = 0; i < good.size(); ++i) {
        if (good.get(i) == 0) // I-th person is bad, no need to check
          continue;
        for (int j = 0; j < statements.length; ++j) {
          if (statements[i][j] == 2)
            continue;
          if (statements[i][j] != good.get(j))
            return false;
        }
      }
      return true;
    }
  }
// @lc code=end

