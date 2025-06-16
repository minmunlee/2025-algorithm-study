import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Min {
    static int[] arr;
    static boolean[] visited;
    static int k;
    static HashSet<String> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        hs = new HashSet<>();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        combine(0, "");
        System.out.println(hs.size());
    }

    public static void combine(int depth, String com){
        if(depth == k){
            hs.add(com);
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combine(depth + 1, com + String.valueOf(arr[i]));
                visited[i] = false;
            }
        }   
    }
}