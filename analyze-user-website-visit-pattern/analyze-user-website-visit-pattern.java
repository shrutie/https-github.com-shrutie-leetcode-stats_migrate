class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp,
                                           String[] website) {
        
        List<Visits> wVisits = new ArrayList<>();
        
        for(int i =0;i<username.length;i++){
            Visits v = new Visits(username[i], website[i], timestamp[i]);
            wVisits.add(v);
        }
        
        Collections.sort(wVisits, (a,b) -> a.time- b.time);
        
        HashMap<String, List<String>> userToSite = new HashMap<>();
        
        for(Visits v : wVisits){
            userToSite.putIfAbsent(v.uname, new ArrayList<String>());
            userToSite.get(v.uname).add(v.website);
        }
        
        Map<List<String>, Integer> freq = new HashMap<>();
        
        
        for(List<String> siteList : userToSite.values()){
            
            if(siteList.size() < 3){
                continue;
            }
            Set<List<String>> seq3OfUser = generate3Seq(siteList);
            
            for(List<String> listOf3: seq3OfUser){
                freq.put(listOf3, freq.getOrDefault(listOf3,0) + 1);
            }  
        }
        int maxm = Integer.MIN_VALUE;
        
        List<String> res = new ArrayList<>();
        
        for(Map.Entry<List<String>, Integer> entry : freq.entrySet()){
           if(entry.getValue() > maxm){
               maxm = entry.getValue();
               res = entry.getKey();
           }
            else if(entry.getValue() == maxm){
                if(entry.getKey().toString().compareTo(res.toString()) < 0){
                    res = entry.getKey();
                }
            }
        }
        return res;
        
    }
    
    private Set<List<String>> generate3Seq(List<String> websitesList) {
		Set<List<String>> setOfListSeq= new HashSet<>();
		for(int i=0;i<websitesList.size();i++){
			for(int j=i+1;j<websitesList.size();j++){
				for(int k=j+1;k<websitesList.size();k++){
					List<String> list = new ArrayList<>();
					list.add(websitesList.get(i));
					list.add(websitesList.get(j));
					list.add(websitesList.get(k));
					setOfListSeq.add(list);
				}
			}
		}
		return setOfListSeq;
	}
    
    class Visits{
        String uname;
        String website;
        int time;
        
        public Visits(String user, String site, int time){
            this.uname = user;
            this.website = site;
            this.time = time;
        }
    }
}