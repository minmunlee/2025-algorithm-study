import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 12; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < 12; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1; i <= 12; i++) {
            int total = 0;
            if(list.get(i).size() == 3) {
                int a = list.get(i).get(0);
                total += list.get(a).size();
                int b = list.get(i).get(1);
                total += list.get(b).size();
                int c = list.get(i).get(2);
                total += list.get(c).size();

                if(total == 6) {
                    System.out.println(i);
                    return;
                }
                
            }
        }
    }    
}
