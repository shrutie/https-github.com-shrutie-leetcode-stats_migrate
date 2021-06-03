class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> list = new ArrayList<>();
        for(int i=0;i<quality.length;i++){
            Worker w = new Worker(quality[i], wage[i]);
            list.add(w);
        }
        
        Collections.sort(list, (a,b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Worker> maxHeap = new PriorityQueue<Worker> ((a,b) -> b.quality-a.quality);
        double cost = Double.MAX_VALUE;
        int qualityHired =0;
        
        for(Worker wrk : list){
            maxHeap.offer(wrk);
            qualityHired += wrk.quality;
            
            if(maxHeap.size() > k){
                Worker w1 = maxHeap.poll();
                qualityHired -= w1.quality;
            }
            if(maxHeap.size() == k){
                cost = Math.min(cost, qualityHired * wrk.ratio);
            }
        }
        return cost;
    }
}

class Worker{
    int quality;
    int wage;
    double ratio;
    
    public Worker(int q, int w){
        this.quality =q;
        this.wage = w;
        this.ratio = (double)this.wage/ this.quality;
    }
}