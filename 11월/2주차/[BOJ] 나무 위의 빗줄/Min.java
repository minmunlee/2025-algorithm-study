import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int W = Integer.parseInt(str.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int cnt = 0;
        for(int i = 2; i <= N; i++) {
            if(list.get(i).size() == 1) {
                cnt += 1;
            }
        }

        System.out.println((double)W / cnt);
    }
}