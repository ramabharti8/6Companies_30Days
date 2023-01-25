/*
 * @lc app=leetcode id=2396 lang=java
 *
 * [2396] Strictly Palindromic Number
 */

// @lc code=start
class Solution {
	public boolean isStrictlyPalindromic(int n) {

	   for (int j = 2; j <= n - 2; j++) {
		   String strX = Integer.toString(n, j);

		   int i = 0, length = strX.length() - 1;
		   while (i <= length / 2) {
			   if (strX.charAt(i) != strX.charAt(length)) {
				   return false;
			   }
			   i++;
			   length--;
		   }
	   }
		return true;
	}
}
// @lc code=end

