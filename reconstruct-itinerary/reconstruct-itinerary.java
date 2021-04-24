class Solution {
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<String>();
        Map<String, PriorityQueue<String>> stnToDest = new HashMap<>();
        
        for(List<String> itinry : tickets){
            String from = itinry.get(0);
            String to = itinry.get(1);
            
            if(stnToDest.containsKey(from)){
                stnToDest.get(from).add(to);
            }
            else{
                PriorityQueue<String> que = new PriorityQueue<String>();
                que.add(to);
                stnToDest.put(from, que);
            }
        }
        
        dfs("JFK", stnToDest);
        return res;
    }
    
    public void dfs(String station, Map<String, PriorityQueue<String>> tktMap){
        
        
        ///System.out.println(station+"->"+ tktMap.get(station));
  
        while(tktMap.containsKey(station) && tktMap.get(station).size() !=0){
            String currStn = tktMap.get(station).poll();
            dfs(currStn, tktMap);
        }
        res.add(0,station);
        
        
    }
}