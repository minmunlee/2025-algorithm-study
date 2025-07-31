import java.io.*;
import java.util.*;

public class Mun {
    static int min;
    static int[] A;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        A = new int[N+1];
        String[] AInput = br.readLine().split(" ");
        for(int i=1;i<=N;i++) {
            A[i] = Integer.parseInt(AInput[i-1]);
        }
        visit = new boolean[N+1];
        list = new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            String[] m = br.readLine().split(" ");
            int v = Integer.parseInt(m[0]);
            int w = Integer.parseInt(m[1]);
            list[v].add(w);
            list[w].add(v);
        }
        int As = 0;
        for(int i=1;i<=N;i++) {
            if(visit[i]) {
                continue;
            }
            min = A[i];
            visit[i] = true;
            findMin(i);
            As+=min;
            if(As > k) {
                break;
            }
        }
        System.out.print((As > k)? "Oh no": As);
    }
    
    private static void findMin(int start) {
        for(int next : list[start]) {
            if(visit[next]) {
                continue;
            }
            visit[next] = true;
            if(min > A[next]) {
                min = A[next];
            }
            findMin(next);
        }
    }
}