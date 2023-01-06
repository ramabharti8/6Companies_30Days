/*
 * @lc app=leetcode id=1976 lang=java
 *
 * [1976] Number of Ways to Arrive at Destination
 */

// @lc code=start
class Solution {
    int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int[] road: roads) {
            map.putIfAbsent(road[0], new ArrayList<>());
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[0]).add(new int[]{road[1], road[2]});
            map.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        // dist, u;
        q.add(new int[]{0,0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;
        
        while(q.size()>0) {
            int[] rem = q.remove();
            int u = rem[1];
            int old_dist = rem[0];
            
            if(map.containsKey(u)) {
                for(int[] list : map.get(u)) {
                    int t = list[1];
                    int v = list[0];
                    
                    int new_dist = t + old_dist;
                    if(new_dist < dist[v]) {
                        q.add(new int[]{new_dist, v});
                        dist[v] = new_dist;
                        ways[v] = ways[u];
                    } else if(new_dist == dist[v]) {
                        ways[v] += ways[u];
                        ways[v] %= MOD;
                    }
                }
            }
        }
        return ways[n-1]%MOD;
    }
}
// @lc code=end

