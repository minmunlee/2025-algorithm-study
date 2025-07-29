import java.io.*;
import java.util.*;

public class Mun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stone = new int[N+1];
        String[] inputStones = br.readLine().split(" ");
        for (int i=1;i<=N;i++) {
            stone[i] = Integer.parseInt(inputStones[i-1]);
        }

        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        int[] visit = new int[N+1];
        Arrays.fill(visit, -1);
        
        Queue<Integer> que = new LinkedList<>();
        que.add(a);
        visit[a] = 0;

        while (que.size()>0) {
            int now = que.poll();
            int jump = stone[now];

            for (int next=now+jump;next<=N;next+=jump) {
                if (visit[next] == -1) {
                    visit[next] = visit[now] + 1;
                    que.add(next);
                }
            }

            for (int next=now-jump;next>=1;next-=jump) {
                if (visit[next] == -1) {
                    visit[next] = visit[now] + 1;
                    que.add(next);
                }
            }
        }

        System.out.println(visit[b]);
    }
}