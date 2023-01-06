/*
 * @lc app=leetcode id=1392 lang=java
 *
 * [1392] Longest Happy Prefix
 */

// @lc code=start
class Solution {
    public String longestPrefix(String s) {
        
         
        int len[]= new int[s.length()];
        int prev=0;
        int i=1;
        
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(prev)){
                len[i]=prev+1;
                prev++;
                i++;
            }else if(prev==0){
                len[i]=0;
                i++;
            }else{
                prev=len[prev-1];
            }
                
        }
        
        int max= len[s.length()-1];

         return s.substring(0, max );
        
        
        
        
    }
}

// @lc code=end

