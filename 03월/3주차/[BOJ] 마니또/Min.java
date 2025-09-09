import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Min {
    public static void main(String[] args) throws IOException{
        int T = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            T += 1;
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            HashMap<String, String> hm = new HashMap<>();
            ArrayList<String> person = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                hm.put(str[0], str[1]);
                person.add(str[0]);
            }

            int loop = 0;
            for(String p : person) {
                String ma = hm.get(p);

                while(true) {
                    ma = hm.get(ma);

                    if(ma == null) {
                        break;
                    }

                    if(ma.equals(p)) {
                        hm.remove(ma);
                        loop += 1;
                        break;
                    }
                }
            }

            System.out.println(T + " " + loop);
        }
    }
}