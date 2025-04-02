import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Min {
    static int[] send = {0 ,0, 1, 1, 2, 2};    // A A B B C C
    static int[] receive = {1, 2, 0, 2, 0, 1}; // B C A C A B
    static int[] now;
    static boolean[][] visited;
    static Set<Integer> amounts;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        now = new int[3];
        now[0] = Integer.parseInt(str.nextToken()); // A
        now[1] = Integer.parseInt(str.nextToken()); // B
        now[2] = Integer.parseInt(str.nextToken()); // C
        visited = new boolean[201][201];
        amounts = new TreeSet<>();
        bfs();
        for(int i : amounts){
            System.out.print(i + " ");
        }
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        amounts.add(now[2]);

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curA = current[0];
            int curB = current[1];
            int curC = now[2] - current[0] - current[1];

            for(int i = 0; i < 6; i++){
                int[] next = {curA, curB, curC};
                next[receive[i]] += next[send[i]];
                next[send[i]] = 0;
                if(next[receive[i]] > now[receive[i]]){ // 물이 넘칠 경우
                    next[send[i]] = next[receive[i]] - now[receive[i]]; // 넘친 양 다시 넣음
                    next[receive[i]] = now[receive[i]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    queue.add(new int[]{next[0], next[1]});
                    if(next[0] == 0) amounts.add(next[2]);
                }

            }
        }
    }
}
