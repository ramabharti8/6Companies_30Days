/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Collections;  
class Solution {
    
    static List<Integer> arr = new ArrayList<Integer>();
    static void Postorder(TreeNode root){
        if(root == null){
            return ;
        }
        Postorder(root.left);
        Postorder(root.right);
        arr.add(root.val);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        arr = new ArrayList<Integer>();
        Postorder(root1);
        Postorder(root2);
        Collections.sort(arr);
        return arr; 
    }
}

// @lc code=end

