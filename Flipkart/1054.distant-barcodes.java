/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length < 3)return barcodes;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int num : barcodes){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return map.get(o2)-map.get(o1);
            }
        });
        for(int num : map.keySet()){
            pq.offer(num);
        }

        for(int i = 0; i < barcodes.length; ++i){
            int curr = pq.poll();
            if(i!=0&&barcodes[i-1]==curr){
                int sec = pq.poll();
                pq.offer(curr);
                curr = sec;
            }
            barcodes[i]=curr;
            map.put(curr, map.get(curr)-1);
            pq.offer(curr);
        }
        return barcodes;
    }
}

// @lc code=end

