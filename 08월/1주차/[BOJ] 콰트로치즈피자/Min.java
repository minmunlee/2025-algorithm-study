import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int topping = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < topping; i++) {
            String t = str.nextToken();
            if(t.length() >= 6) {
                String tmp = t.substring(t.length() - 6, t.length());
                if(tmp.equals("Cheese")) hs.add(t);
            }
        }

        if(hs.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}