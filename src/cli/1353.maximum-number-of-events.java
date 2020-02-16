class Solution {
    public int maxEvents(int[][] events) {
        // æååæéæå
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> meetingPool = new PriorityQueue();
        int iterIndex = 0; // äæååçç0ämeetingåå
        int result = 0;
        int len = events.length;
        for(int day = 1; day <= 100000; day++) {   // äçäååååæ
            while(iterIndex < len && events[iterIndex][0] == day) {  // åæ `åæ` çååæéæ åååçåçæåçè
                meetingPool.offer(events[iterIndex++][1]); // åæååæåççææææåpoolé；
            }
            while(meetingPool.size() != 0 && meetingPool.peek() < day) {
                meetingPool.poll();  // åæpqéççæææåçåääåçè，åæçpool
            }
            if (meetingPool.size() > 0) {
                meetingPool.poll();   // ææåçææéæåçéäevent åèè
                result++;
            }
        }
        return result;
        
    }
}