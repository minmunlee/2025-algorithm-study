import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Min {
    static int[][] city;
    static List<int[]> chicken;
    static List<int[]> house;
    static boolean[] visited;
    static int N, M, min, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        city  = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(str.nextToken());
                city[i][j] = num;
                
                if(num == 1) {
                    house.add(new int[]{i, j});
                }

                if(num == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;
        getStreet(0, 0);

        System.out.println(answer);
    }

    private static void getStreet(int cnt, int start) {
        if(cnt == M) {
            getDis();
        }
        for(int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            getStreet(cnt + 1, i + 1);
            visited[i] = false;
        }
    }   

    private static void getDis() {
        int sum = 0;
        for(int i = 0; i < house.size(); i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < chicken.size(); j++) {
                if(visited[j]) {
                    int[] housePos = house.get(i);
                    int[] chickenPos = chicken.get(j);
                    int dis = Math.abs(housePos[0] - chickenPos[0]) + Math.abs(housePos[1] - chickenPos[1]);
                    min = Math.min(min, dis);
                }
            }
            sum += min;
        }
        answer = Math.min(answer, sum);
        return;
    }
}
