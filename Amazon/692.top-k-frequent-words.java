/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map=new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list=new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry);
        } 
        Collections.sort(list, new SortComp());
        list.subList(k, list.size()).clear();
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String, Integer> entry : list){
            ans.add(entry.getKey());
        }
        return ans;
    }
    static class SortComp implements Comparator<Map.Entry<String, Integer>> {
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
            int a = -1*o1.getValue().compareTo(o2.getValue());
            if(a == 0){
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return a;
            }
        }
    }
}
// @lc code=end

