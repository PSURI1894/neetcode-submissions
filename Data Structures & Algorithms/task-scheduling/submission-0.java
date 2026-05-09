class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }       
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);
        for(int freq : count){
            if(freq > 0){
                maxheap.offer(freq);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!maxheap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxheap.isEmpty()){
                int freq = maxheap.poll() - 1;
                if(freq > 0){
                    queue.offer(new int[]{freq, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxheap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}