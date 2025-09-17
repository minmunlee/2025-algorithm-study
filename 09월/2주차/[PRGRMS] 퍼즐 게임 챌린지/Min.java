class Min {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;

        while(left <= right) {
            int mid = (left + right) / 2;
            long time = calculate(diffs, times, mid);
            if(time > limit) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }  
    
    private static long calculate(int[] diffs, int[] times, int level) {
        long sum = 0;
        for(int i = 0; i < times.length; i++) {
            if(diffs[i] <= level) {
                sum += times[i];
            } else {
                if(i == 0) {
                    sum += times[i] * (diffs[i] - level + 1);
                } else{
                    sum += (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                }
            }
        }
        
        return sum;
    }
}