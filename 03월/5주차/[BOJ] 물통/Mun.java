import java.io.*;
import java.util.*;

public class Mun {

    static int[] ABC = new int[3];
    static boolean[][][] visited = new boolean[201][201][201];
    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        ABC[0] = Integer.parseInt(input[0]);
        ABC[1] = Integer.parseInt(input[1]);
        ABC[2] = Integer.parseInt(input[2]);

        DFS(new int[]{0, 0, ABC[2]});

        StringBuilder sb = new StringBuilder();
        for (int num : set) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void DFS(int[] abc) {
        if (visited[abc[0]][abc[1]][abc[2]]) return;
        visited[abc[0]][abc[1]][abc[2]] = true;

        if (abc[0] == 0) {
            set.add(abc[2]);
        }

        for (int i = 0; i < 3; i++) {
            if (abc[i] == 0) continue;

            for (int j = 1; j < 3; j++) {
                int otherIndex = (i + j) % 3;
                if (abc[otherIndex] == ABC[otherIndex]) continue;

                int[] next = abc.clone();
                int moveAmount = Math.min(next[i], ABC[otherIndex] - next[otherIndex]);
                
                next[i] -= moveAmount;
                next[otherIndex] += moveAmount;

                DFS(next);
            }
        }
    }
}