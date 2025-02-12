import java.util.*;
 
class Min {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minqueue = new PriorityQueue<>();
        int[] answer;
        
        for(int i = 0; i < operations.length; i++){
            String[] str = operations[i].split(" ");
            String op = str[0];
            int num = Integer.parseInt(str[1]);
            
            if(op.equals("I")){
                maxqueue.add(num);
                minqueue.add(num);
            }else{
                if(!maxqueue.isEmpty()){
                    if(num == -1){
                        int min = minqueue.poll();
                        maxqueue.remove(min);
                    }else{
                        int max = maxqueue.poll();
                        minqueue.remove(max);
                    }
                }
            }
        }
        
        if(maxqueue.size() == 0 && minqueue.size() == 0){
            answer = new int[]{0, 0};
        }else{
            answer = new int[]{maxqueue.peek(), minqueue.peek()};
        }
        return answer;
    }
}
