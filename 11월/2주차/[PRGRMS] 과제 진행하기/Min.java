import java.util.*;

class Min {
    public String[] solution(String[][] plans) {
        Stack<String[]> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        
        Arrays.sort(plans, (a, b) -> toMinute(a[1]) - toMinute(b[1]));
        
        for(int i = 0; i < plans.length - 1; i++) {
            String subject = plans[i][0];
            int start = toMinute(plans[i][1]);
            int time = Integer.parseInt(plans[i][2]);
            int end = start + time;
            int next = toMinute(plans[i + 1][1]);
            
            if(end > next) {
                int t = end - next;
                stack.push(new String[]{subject, String.valueOf(t)});
            } else {
                list.add(subject);
                int t = next - end;
                while(t > 0 && !stack.isEmpty()) {
                    String[] tmp = stack.pop();
                    String sub = tmp[0];
                    int reTime = Integer.parseInt(tmp[1]);
                    
                    if(reTime > t) {
                        reTime -= t;
                        stack.push(new String[]{sub, String.valueOf(reTime)});
                        t = 0;
                    }else {
                        list.add(sub);
                        t -= reTime;
                    }
                }
            }
        }
        
        list.add(plans[plans.length- 1][0]);
        while(!stack.isEmpty()) {
            String[] tmp = stack.pop();
            list.add(tmp[0]);
        }
        
        String[] answer = list.toArray(new String[plans.length]);
        
        return answer;
    }
    
    private int toMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}